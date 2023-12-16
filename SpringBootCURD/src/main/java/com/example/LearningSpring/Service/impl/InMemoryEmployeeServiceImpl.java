package com.example.LearningSpring.Service.impl;

import com.example.LearningSpring.Model.Employee;
import com.example.LearningSpring.Repository.InMemoryEmployeeRepository;
import com.example.LearningSpring.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class InMemoryEmployeeServiceImpl implements EmployeeService {
    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return inMemoryEmployeeRepository.getAllEmployee();
    }

    @Override
    public Employee getEmployee(Integer id) {
        return inMemoryEmployeeRepository.getEmployee(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteEmployee(Integer id) {
        return inMemoryEmployeeRepository.deleteEmployee(id);
    }
}
