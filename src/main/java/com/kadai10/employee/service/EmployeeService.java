package com.kadai10.employee.service;

import com.kadai10.employee.entity.Employee;
import com.kadai10.employee.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public List<Employee> findAll() {
        return employeeMapper.getAll();
    }

    public Employee findById(int id) {
        return employeeMapper.findByEmployeeId(id);
    }

    public Employee insert(String name, int age, String mail) {
        Employee employee = new Employee(name, age, mail);
        employeeMapper.insert(employee);
        return employee;
    }

}
