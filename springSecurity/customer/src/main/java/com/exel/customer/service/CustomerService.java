package com.exel.customer.service;

import java.util.List;

import com.exel.customer.dto.AddressListDto;
import com.exel.customer.dto.CustomerInformationDto;

public interface CustomerService {

	public String addCustomerDetails(CustomerInformationDto dto);

	public List<CustomerInformationDto> getAllCustomers(String customerPhone, Integer customerId, String email, String customerName, Integer customerAge);

	public CustomerInformationDto getbyId(CustomerInformationDto dto);

	public String deleteCustomer(CustomerInformationDto dto);

	public CustomerInformationDto updateCustomer(CustomerInformationDto dto);

	public String addAddress(AddressListDto dto);

}
