package com.exel.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.exel.customer.commonresponse.CommonResponse;
import com.exel.customer.dto.AddressListDto;
import com.exel.customer.dto.CustomerInformationDto;
import com.exel.customer.dto.JwtAuthRequestDto;
import com.exel.customer.exception.CustomerNotFoundException;
import com.exel.customer.service.CustomerService;
import com.exel.customer.service.JwtService;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_DATA_ADDED_SUCCESS;
import static com.exel.customer.constants.CustomerConstants.TOKEN_GENERATED_SUCCESS;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_DATA_FETCHED_SUCCESS;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_DATA_UPDATED_SUCCESS;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_NOT_FOUND;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_DATA_DELETED_SUCCESS;
import static com.exel.customer.constants.CustomerConstants.CUSTOMERS_DATA_FETCHED_SUCCESS;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_ADDRESS_ADDED_SUCCESS;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
@RestController
@RequestMapping(path = "/api", method = { RequestMethod.POST, RequestMethod.PUT })
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/customer")
	public ResponseEntity<CommonResponse<String>> addCustomerDetails(@RequestBody CustomerInformationDto dto) {
		String savedCustomerData = customerService.addCustomerDetails(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(savedCustomerData)
				.isError(false).message(CUSTOMER_DATA_ADDED_SUCCESS).build());
	}

	 @PreAuthorize("hasAuthority('USER')")
	@GetMapping("/customer/getall")
	public ResponseEntity<CommonResponse<List<CustomerInformationDto>>> getAllCustomers(
			@RequestParam(required = false, defaultValue = "") Integer customerAge,
			@RequestParam(required = false, defaultValue = "") String customerName,
			@RequestParam(required = false, defaultValue = "") Integer customerId,
			@RequestParam(required = false, defaultValue = "") String email,
			@RequestParam(required = false, defaultValue = "") String customerPhone) {
		List<CustomerInformationDto> allCustomers = customerService.getAllCustomers(customerPhone, customerId, email,
				customerName, customerAge);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<List<CustomerInformationDto>>builder()
				.data(allCustomers).isError(false).message(CUSTOMERS_DATA_FETCHED_SUCCESS).build());
	}

	 @PreAuthorize("hasAuthority('USER')")
	@GetMapping("/customer/get")
	public ResponseEntity<CommonResponse<CustomerInformationDto>> getbyId(
			@RequestBody @RequestParam(required = false, defaultValue = "") Integer customerId,
			@RequestParam(required = false, defaultValue = "") Integer customerAge,
			@RequestParam(required = false, defaultValue = "") String customerName,
			@RequestParam(required = false, defaultValue = "") String email,
			@RequestParam(required = false, defaultValue = "") String customerPhone, CustomerInformationDto dto) {
		CustomerInformationDto getCustomer = customerService.getbyId(dto);
		System.out.println("entry for controller");
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<CustomerInformationDto>builder()
				.data(getCustomer).isError(false).message(CUSTOMER_DATA_FETCHED_SUCCESS).build());
	}

	@DeleteMapping("/customer/delete")
	public ResponseEntity<CommonResponse<String>> deleteCustomer(@RequestBody CustomerInformationDto dto) {
		String deleteCustomer = customerService.deleteCustomer(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(deleteCustomer)
				.isError(false).message(CUSTOMER_DATA_DELETED_SUCCESS).build());
	}

	@PutMapping("/customer/put")
	public ResponseEntity<CommonResponse<CustomerInformationDto>> updateCustomer(
			@RequestBody CustomerInformationDto dto) {
		CustomerInformationDto updateCustomer = customerService.updateCustomer(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<CustomerInformationDto>builder()
				.data(updateCustomer).isError(false).message(CUSTOMER_DATA_UPDATED_SUCCESS).build());
	}

	@PostMapping("/address")
	public ResponseEntity<CommonResponse<String>> addAddress(@RequestBody AddressListDto dto) {
		String addCustomerAddress = customerService.addAddress(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(addCustomerAddress)
				.isError(false).message(CUSTOMER_ADDRESS_ADDED_SUCCESS).build());
	}

	@PostMapping("/authenticate")
	public ResponseEntity<CommonResponse<String>> authenticateAndGetToken(@RequestBody JwtAuthRequestDto dto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
		
		if (authentication.isAuthenticated()) {
			System.out.println("I'm in Controller!!");
			String tokens = jwtService.generateToken(dto.getUsername());
			return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().isError(false)
					.message(TOKEN_GENERATED_SUCCESS).data(tokens).build());
		} else {
			throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);
		}

	}

}
