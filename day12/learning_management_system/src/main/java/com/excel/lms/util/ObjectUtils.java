package com.excel.lms.util;

import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.entity.EmployeePrimaryInfo;

public class ObjectUtils {
private ObjectUtils() {
	
}

public static EmployeePrimaryInfo dtoToEntity( EmployeePrimaryInfoDto dto) {
	return EmployeePrimaryInfo.builder().id(dto.getId()).employeeId(dto.getEmployeeId())
			.dateOfJoining(dto.getDateOfJoining()).dateOfBirth(dto.getDateOfBirth())
			.email(dto.getEmail()). bloodGroup(dto.getBloodGroup())
			.employeeName(dto.getEmployeeName())
			.nationality(dto.getNationality())
			.gender(dto.getGender()).designation(dto.getDesignation())
			.employeeStatus(dto.getEmployeeStatus()).build();
}
}
