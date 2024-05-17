package com.excel.lms.dto;

import java.time.LocalDate;

import com.excel.lms.enums.EducationalType;

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
public class EmployeeEducationDetailsDto {
	private Integer id;
	private EducationalType educationType;
	private Double pecentage;
	private String specilization;
	private String instituteName;
	private String universityName;
	private String district;
	private String state;
	private LocalDate yearOfPassing;
}
