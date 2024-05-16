package com.example.demo.util;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public class EmployeeUtil {
	private EmployeeUtil() {
		
	}
public static EmployeeDto entityToDto(Employee save) {
	return  EmployeeDto.builder().id(save.getId())
			.aadharNo(save.getAadharNo()).firstName(save.getFirstName())
			.lastName(save.getLastName()).panNo(save.getPanNo())
			.employeeNo(save.getEmployeeNo()).build();
	
}
}
