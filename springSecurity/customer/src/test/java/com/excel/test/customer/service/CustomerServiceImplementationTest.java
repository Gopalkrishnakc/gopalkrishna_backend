package com.excel.test.customer.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.exel.customer.dto.CustomerInformationDto;
import com.exel.customer.entity.CustomerInformation;
import com.exel.customer.exception.CustomerNotFoundException;
import com.exel.customer.repository.CustomerInformationRepository;
import com.exel.customer.service.CustomerServiceImplementation;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplementationTest {
	@Mock
	private CustomerServiceImplementation customerServiceImplementation;
	@MockBean
	private CustomerInformationRepository customerInformationRepository;

	@Test
	public void testApiCustomerDetailsAdding()throws Exception {
		CustomerInformationDto dto = new CustomerInformationDto();
		CustomerInformation customer = new CustomerInformation();
		when(customerInformationRepository.save(any(CustomerInformation.class))).thenReturn(customer);
		String result = customerServiceImplementation.addCustomerDetails(dto);
		assertNotNull(result);
	}

	@Test
	public void CustomerNotExist_ThenTrowException() {
		CustomerInformationDto dto = new CustomerInformationDto();
		when(customerInformationRepository.findByCustomerId(anyInt())).thenReturn(Optional.empty());
		assertThrows(CustomerNotFoundException.class, () -> {
			customerServiceImplementation.deleteCustomer(dto);
		});
	}
}
