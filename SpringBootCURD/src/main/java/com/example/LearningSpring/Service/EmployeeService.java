package com.example.LearningSpring.Service;

import com.example.LearningSpring.Model.Employee;

import java.util.List;

public interface EmployeeService {
    //save employee
    Employee addEmployee(Employee employee);
    // get employee
    List<Employee> getAllEmployee();
    // get particular employee
    Employee getEmployee(Integer id);
    // update employee
    Employee updateEmployee(Employee employee);
    // delete employee
    Boolean deleteEmployee(Integer id);

}
