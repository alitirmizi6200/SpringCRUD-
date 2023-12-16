package com.example.LearningSpring.Service.impl;

import com.example.LearningSpring.Model.Employee;
import com.example.LearningSpring.Repository.JpaEmployeeRepository;
import com.example.LearningSpring.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Qualifier(value = "myQSLEmployeeService")
@RequiredArgsConstructor
@Service
public class JpaEmployeeServiceImpl implements EmployeeService {
    private final JpaEmployeeRepository jpaEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return jpaEmployeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return jpaEmployeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return jpaEmployeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee UpdateEmp = jpaEmployeeRepository.findById(employee.getId()).get();
        UpdateEmp.setFirstName(employee.getFirstName());
        UpdateEmp.setLastName(employee.getLastName());
        UpdateEmp.setEmail(employee.getEmail());
        return jpaEmployeeRepository.save(UpdateEmp);
    }

    @Override
    public Boolean deleteEmployee(Integer id) {
        try {
            jpaEmployeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println("Error deleting " + e);
            return false;
        }
    }
}