package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.EmployeeDto;

public interface EmployeeService {
public EmployeeDto addEmployee(EmployeeDto employee);
public void deleteEmployee(EmployeeDto dto);
public List<EmployeeDto>getAllEmployees();
public EmployeeDto updateEmployee(EmployeeDto dto,Integer id);
public EmployeeDto getEmployee(EmployeeDto dto);

}
