package com.example.LearningSpring.Repository;

import com.example.LearningSpring.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEmployeeRepository extends JpaRepository<Employee ,Integer> {
}