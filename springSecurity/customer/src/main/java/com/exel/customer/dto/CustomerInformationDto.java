package com.exel.customer.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
public class CustomerInformationDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	private Integer customerAge;
	@NotBlank(message = "Name is mandatory")
	@Size(min=2, max=30)
	private String customerName;
	@NotBlank
	@Pattern(regexp = "^[0-9]{10}$",message = "10 digits requied!!")
	private String customerPhone;
	@Email
	@Column(unique=true)
	private String email;
	private String password;
	private String roles;
	
}
