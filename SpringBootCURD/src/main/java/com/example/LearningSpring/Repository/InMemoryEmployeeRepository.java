package com.example.LearningSpring.Repository;

import com.example.LearningSpring.Model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//DAO Data Access Object
@Repository
public class InMemoryEmployeeRepository {
    private static final List<Employee> DATABASE = new ArrayList<>();

    static  {
        DATABASE.add(new Employee(0, "John","Doe","JohnDoe@gmail.com"));
        DATABASE.add(new Employee(1, "Doe","John","DoeJhon@gmail.com"));
        DATABASE.add(new Employee(2, "John","John","JohnJohn@gmail.com"));
    }

    public Employee addEmployee(Employee employee){
        DATABASE.add(employee);
        return employee;
    }
    // get employee
    public List<Employee> getAllEmployee(){

        return List.copyOf(DATABASE);
    }
    // get particular employee
    public Employee getEmployee(Integer id) {
        return DATABASE
                .stream().
                filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
    }
    // update employee
    public Employee updateEmployee(Employee employee){
        Employee existingEmp = DATABASE.stream()
                .filter(emp -> employee.getId().equals(emp.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Employee not found with ID: " + employee.getId()));
        existingEmp.setFirstName(employee.getFirstName());
        existingEmp.setLastName(employee.getLastName());
        existingEmp.setEmail(employee.getEmail());

        return employee;
    }
    // delete employee
    public Boolean deleteEmployee(Integer id){
        Employee deleteEmp = DATABASE.stream()
                .filter(emp -> id.equals(emp.getId()))
                .findFirst()
                .orElseThrow();
        DATABASE.remove(deleteEmp);
        return true;
    }
}
