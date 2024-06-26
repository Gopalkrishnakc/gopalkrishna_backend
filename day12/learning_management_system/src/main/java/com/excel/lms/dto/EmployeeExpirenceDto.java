package com.excel.lms.dto;

import java.time.LocalDate;

import com.excel.lms.enums.Designation;

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
public class EmployeeExpirenceDto {
	private Integer id;
	
	private String companyName;
	private String yearsOfExpirence;
	private LocalDate dateOfJoining;
	private LocalDate dateOfReliving;
	private Designation designation;
	private String location;
}
