package com.excel.lms.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeePrimaryInfoDto {
	private Integer id;
	private String employeeId;
	private String employeeName;
	private LocalDate dateOfJoining;
	private LocalDate dateOfBirth;
	private String email;
	private String bloodGroup;
	private String designation;
	private String gender;
	private String nationality;
	private String employeeStatus;
}
