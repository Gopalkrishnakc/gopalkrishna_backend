package com.excel.lms.dto;
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
public class EmployeeSkillsDto {
	private  Integer id;
	private String skillType;
	private String yearOfExpirence;
	private String skillRating;
}
