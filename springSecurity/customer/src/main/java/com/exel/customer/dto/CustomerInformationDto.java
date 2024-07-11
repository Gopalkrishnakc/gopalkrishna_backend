package com.exel.customer.dto;





import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerInformationDto {
	private Integer customerId;
	private Integer customerAge;
	private String customerName;
	private String customerPhone;
	private String email;
	private String password;
	private String roles;
}
