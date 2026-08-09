package com.employeeManagement.employee_management.controllers;


import com.employeeManagement.employee_management.entities.Employee;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private final ArrayList<Employee> employees = new ArrayList<>(
            List.of(
                    new Employee(UUID.randomUUID(),"ahmed","medhat","ahmed@email.com","01020102103" , "Backend Developer", LocalDate.of(2024,7,7),UUID.randomUUID()
            ))
    );
    @GetMapping
    public ArrayList<Employee> getEmployees(){
        return this.employees;
    }
    @GetMapping("/{employeeId}")
    public Optional<Employee> findOne(@PathVariable UUID employeeId){
        return this.employees.stream().filter(emp->emp.getId().equals(employeeId)).findFirst();
    }
//    @PostMapping
//    public Employee createHello(@RequestBody Employee employee){
//        this.employees.add(employee);
//        return employee;
//    }
}
