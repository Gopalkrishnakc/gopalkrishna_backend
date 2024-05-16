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
public class EmployeeSecondaryInfoDto {
	private Integer id;
	private String panNo;
	private String aadharNo;
	private String fatherName;
	private String motherName;
	private String spouseName;
	private String maritalStatus;
	private String passportNo;
}
