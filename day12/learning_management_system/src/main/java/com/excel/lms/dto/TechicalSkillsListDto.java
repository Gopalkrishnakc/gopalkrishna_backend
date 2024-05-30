package com.excel.lms.dto;

import java.util.List;

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
public class TechicalSkillsListDto {
	private String employeeId;
	private List< EmployeeSkillsDto> technicalSkills;
	
}
