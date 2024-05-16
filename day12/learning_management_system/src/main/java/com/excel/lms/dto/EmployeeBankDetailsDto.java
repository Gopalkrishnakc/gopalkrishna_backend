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
public class EmployeeBankDetailsDto {
	private Integer id;
	private String bankName;
	private String branch;
	private String accountNo;
	private String accountType;
	
	private String ifsc;
	private String state;
}
