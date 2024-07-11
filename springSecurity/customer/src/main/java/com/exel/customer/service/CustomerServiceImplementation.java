package com.exel.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exel.customer.dto.AddressListDto;
import com.exel.customer.dto.CustomerInformationDto;
import com.exel.customer.entity.Address;
import com.exel.customer.entity.CustomerInformation;
import com.exel.customer.exception.AddressNotFoundException;
import com.exel.customer.exception.CustomerNotFoundException;
import com.exel.customer.repository.CustomerInformationRepository;
import com.exel.customer.utils.UtilsObject;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_ID_NOT_FOUND;
import static com.exel.customer.constants.CustomerConstants.CUSTOMERS_NOT_FOUND;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_NOT_FOUND;
import static com.exel.customer.constants.CustomerConstants.CUSTOMER_DATA_DELETED_SUCCESS;

@Service
public class CustomerServiceImplementation implements CustomerService {
	@Autowired
	private CustomerInformationRepository customerInformationRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String addCustomerDetails(CustomerInformationDto dto) {

		try {
			Optional<CustomerInformation> optional = customerInformationRepository
					.findByCustomerId(dto.getCustomerId());
			if (!optional.isPresent()) {
				CustomerInformation customer = UtilsObject.dtoToEntity(dto);
				customer.setPassword(passwordEncoder.encode(dto.getPassword()));
				customerInformationRepository.save(customer);
				return customer.getEmail();
			}
		} catch (Exception e) {
			throw new CustomerNotFoundException(CUSTOMER_ID_NOT_FOUND);
		}
		throw new CustomerNotFoundException(CUSTOMER_ID_NOT_FOUND);
	}

	@Override
	public List<CustomerInformationDto> getAllCustomers(String customerPhone, Integer customerId, String email,
			String customerName, Integer customerAge) {

		List<CustomerInformation> customers = customerInformationRepository
				.findByCustomerPhoneOrCustomerIdOrEmailOrCustomerNameOrCustomerAge(customerPhone, customerId, email,
						customerName, customerAge);
		if (customers.isEmpty()) {
			throw new CustomerNotFoundException(CUSTOMERS_NOT_FOUND);
		} else {

			return customers.stream()
					.map(o -> CustomerInformationDto.builder().customerName(o.getCustomerName())
							.customerAge(o.getCustomerAge()).customerPhone(o.getCustomerPhone()).email(o.getEmail())
							.customerId(o.getCustomerId()).build())
					.toList();

		}

	}

	@Override
	public CustomerInformationDto getbyId(CustomerInformationDto dto) {
		Optional<CustomerInformation> optional = customerInformationRepository
				.findByCustomerPhoneOrCustomerIdOrEmailOrCustomerAge(dto.getCustomerPhone(), dto.getCustomerId(),
						dto.getEmail(), dto.getCustomerAge());
		if (optional.isPresent()) {
			CustomerInformation customer = optional.get();
			return UtilsObject.entityToDTo(customer);
		}
		throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);
	}

	@Override
	public String deleteCustomer(CustomerInformationDto dto) {
		Optional<CustomerInformation> optional = customerInformationRepository.findByCustomerId(dto.getCustomerId());
		if (optional.isPresent()) {
			CustomerInformation customer = optional.get();
			customerInformationRepository.delete(customer);
			return CUSTOMER_DATA_DELETED_SUCCESS;
		}
		throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);
	}

	@Override
	public CustomerInformationDto updateCustomer(CustomerInformationDto dto) {
		Optional<CustomerInformation> optional = customerInformationRepository.findByCustomerId(dto.getCustomerId());
		if (optional.isPresent()) {
			CustomerInformation customer = optional.get();
			customer = UtilsObject.updateCustomer(customer, dto);
			CustomerInformation customer1 = customerInformationRepository.save(customer);
			return UtilsObject.entityToDTo(customer1);

		}
		throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);
	}

	@Override
	public String addAddress(AddressListDto dto) {
		Optional<CustomerInformation> optional = customerInformationRepository.findByEmail(dto.getEmail());
		try {
			if (optional.isPresent()) {
				CustomerInformation customer = optional.get();
				List<Address> addresses = UtilsObject.dtoToEntity(dto.getAddress());
				customer.setAddress(addresses);
				addresses.stream().forEach(a -> a.setCustomerInfo(customer));

				customerInformationRepository.save(customer);
				return customer.getEmail();
			}
		} catch (Exception e) {
			throw new AddressNotFoundException(CUSTOMER_DATA_DELETED_SUCCESS);
		}
		throw new AddressNotFoundException(CUSTOMER_DATA_DELETED_SUCCESS);
	}

}
