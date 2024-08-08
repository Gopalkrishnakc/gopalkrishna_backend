package com.excel.test.customer.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.exel.customer.commonresponse.CommonResponse;
import com.exel.customer.controller.CustomerController;
import com.exel.customer.dto.CustomerInformationDto;
import com.exel.customer.service.CustomerService;


@WebMvcTest(CustomerController.class)
public class CustomerInformationControllerTest {

	@InjectMocks
	private CustomerController customerController;

	@SpyBean
	private CustomerService customerService;

//	@Before(value = "")
//	public void before() {
//		MockitoAnnotations.initMocks(customerController);
//		 mockMvc = MockMvcBuilders
//		            .webAppContextSetup(context)
//		            .apply(SecurityMockMvcConfigurers.springSecurity())
//		            .build();
//	}
//	public void whenGetAllProducts_thenReturnsJsonArray() throws Exception {
//    List<CustomerInformationDto> customers=Arrays.asList(
//    		new CustomerInformationDto(1,12,"Daniel Dilip","7676840350","dilip@gmail.com","USER","76Dilip@"),
//    		new CustomerInformationDto(2,22,"Daniel ","7676840350","daniel@gmail.com","USER","76Daniel@")
//    		);
//    when(customerService.getAllCustomers( anyString(),anyInt() , anyString(), anyString(),anyInt())).thenReturn(customers);
//    mockMvc.perform(get("/api/customer/getall")).andExpect(status().isOk())
//    .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
//    .andExpect(jsonPath("$[0].age",is("dilip@gmail.com")))
//    .andExpect(jsonPath("$[1].age",is("daniel@gmail.com")));
//       
//	}

	@Test
	public void givenCustomerObject_Create_And_SaveCustomerDetails() throws Exception {

		CustomerInformationDto customer = CustomerInformationDto.builder().customerAge(12).customerId(3)
				.customerName("akshay").customerPhone("6360637006").email("aakshay@gmail.com").password("76Akshay@")
				.roles("USER").build();
		when(customerService.addCustomerDetails(customer)).thenReturn(customer.getEmail());
		
		ResponseEntity<CommonResponse<String>> customerDetails = customerController.addCustomerDetails(customer);
		
		assertEquals(HttpStatus.OK, customerDetails.getStatusCode());
		CommonResponse<String> res=customerDetails.getBody();
		assertNotNull(res);
		assertEquals("aakshay@gmail.com",res.getData());
		assertEquals("customer Added Success!!",res.getMessage());
		assertFalse(res.getIsError());

	}

}