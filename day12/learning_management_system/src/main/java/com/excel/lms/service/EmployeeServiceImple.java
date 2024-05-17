package com.excel.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.util.ObjectUtils;
@Service
public class EmployeeServiceImple implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeePrimaryInfoDto addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto) {
		
		if(!employeeRepository.findByEmployeeId(dto.getEmployeeId()).isPresent()) {
			EmployeePrimaryInfo employee1=ObjectUtils.dtoToEntity(dto);
			EmployeePrimaryInfo employee=employeeRepository.save(employee1);
			return EmployeePrimaryInfoDto.builder().employeeId(employee.getEmployeeId()).build();
		}
         return null;
	}

}
