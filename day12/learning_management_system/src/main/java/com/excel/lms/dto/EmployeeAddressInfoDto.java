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
public class EmployeeAddressInfoDto {
	private Integer id;
	private String addressType;
	private String doorNo;
	private String street;
	private String locality;
	private String city;
	private String state;
	private String landMark;
	private Long pin;
}
