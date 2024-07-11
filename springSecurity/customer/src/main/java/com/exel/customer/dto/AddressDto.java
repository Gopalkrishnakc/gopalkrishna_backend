package com.exel.customer.dto;



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
public class AddressDto {
	private Integer customerId;
	 private Integer addressId;
	  private String addressType;
	  private String city;
	  private String place;
	  private String district;
	  private String state;
	  private String pincode;
}
