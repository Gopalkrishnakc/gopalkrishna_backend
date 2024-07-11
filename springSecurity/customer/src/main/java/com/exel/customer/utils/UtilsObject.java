package com.exel.customer.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.exel.customer.dto.AddressDto;
import com.exel.customer.dto.AdminDto;
import com.exel.customer.dto.CustomerInformationDto;
import com.exel.customer.entity.Address;
import com.exel.customer.entity.Admin;
import com.exel.customer.entity.CustomerInformation;

public class UtilsObject {

	public static CustomerInformation dtoToEntity(CustomerInformationDto dto) {
		
		return CustomerInformation.builder().customerAge(dto.getCustomerAge()).customerName(dto.getCustomerName())
			.roles(dto.getRoles()).password(dto.getPassword()).customerPhone(dto.getCustomerPhone()).email(dto.getEmail()).build() ;
	}

	public static CustomerInformationDto entityToDTo(CustomerInformation customer) {
		
		return CustomerInformationDto.builder().customerAge(customer.getCustomerAge())
				.customerId(customer.getCustomerId()).customerName(customer.getCustomerName())
				.roles(customer.getRoles()).customerPhone(customer.getCustomerPhone()).email(customer.getEmail()).build();
	}

	public static CustomerInformation updateCustomer(CustomerInformation customer, CustomerInformationDto dto) {
		customer.setCustomerAge(dto.getCustomerAge());
		customer.setCustomerName(dto.getCustomerName());
		customer.setCustomerPhone(dto.getCustomerPhone());
		customer.setEmail(dto.getEmail());
		customer.setPassword(dto.getPassword());
		customer.setRoles(dto.getRoles());
		return customer;
	}

	public static List<Address> dtoToEntity(List<AddressDto> address) {
	
		return address.stream().map(a->Address.builder().addressType(a.getAddressType())
				.city(a.getCity()).district(a.getDistrict()).place(a.getPlace())
				.state(a.getState()).pincode(a.getPincode()).build()).collect(Collectors.toList());
	}

	public static Admin itemsDtoToEntity(AdminDto dto) {
		return Admin.builder().adminame(dto.getAdminame()).adminId(dto.getAdminId())
				.email(dto.getEmail()).password(dto.getPassword()).build();
	
	}

}
