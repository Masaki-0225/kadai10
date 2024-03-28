package com.kadai10.employee.controller;

import com.kadai10.employee.entity.CreateForm;
import com.kadai10.employee.entity.Employee;
import com.kadai10.employee.entity.UpdateForm;
import com.kadai10.employee.response.EmployeeResponse;
import com.kadai10.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    public Optional<Employee> getEmployee(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeResponse> insert(@RequestBody @Validated CreateForm form, UriComponentsBuilder uriBuilder) {
        Employee employee = employeeService.insert(form.getName(), form.getAge(), form.getMail());
        URI location = uriBuilder.path("employee/{id}").buildAndExpand(employee.getId()).toUri();
        EmployeeResponse body = new EmployeeResponse("created successfully!!!");
        return ResponseEntity.created(location).body(body);
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> update(@RequestBody @Validated UpdateForm form,
                                                   @PathVariable(value = "id") int id) {
        employeeService.updateEmployee(id, form.getName(), form.getAge(), form.getMail());
        EmployeeResponse body = new EmployeeResponse("Employee was successfully updated");
        return ResponseEntity.ok(body);

    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<EmployeeResponse> delete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        EmployeeResponse body = new EmployeeResponse("Employee was successfully delete");
        return ResponseEntity.ok(body);
    }
}
