package com.kadai10.employee.controller;

import com.kadai10.employee.entity.CreateForm;
import com.kadai10.employee.entity.Employee;
import com.kadai10.employee.response.EmployeeResponse;
import com.kadai10.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeResponse> insert(@RequestBody CreateForm form, UriComponentsBuilder uriBuilder) {
        Employee employee = employeeService.insert(form.getName(), form.getAge(), form.getMail());
        URI location = uriBuilder.path("employee/{id}").buildAndExpand(employee.getId()).toUri();
        EmployeeResponse body = new EmployeeResponse("created successfully!!!");
        return ResponseEntity.created(location).body(body);
    }
}
