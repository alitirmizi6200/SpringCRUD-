package com.example.LearningSpring.Controller;

import com.example.LearningSpring.Model.Employee;
import com.example.LearningSpring.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//@RequiredArgsConstructor
@CrossOrigin(origins = "https://dashboard.whatabyte.app")
@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(@Qualifier(value = "myQSLEmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployees(@RequestBody Employee employee){
        employee.setId(employeeService.getAllEmployee().size());
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployees(@RequestBody Employee employee){
        return ResponseEntity.
        created(getLocation(employee.getId())).body(employeeService.updateEmployee(employee));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployees(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

    private URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(id).toUri();
    }
}
