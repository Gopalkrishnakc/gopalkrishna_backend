package com.exel.customer.security.config;


import static com.exel.customer.constants.CustomerConstants.CUSTOMER_NOT_FOUND;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.exel.customer.entity.CustomerInformation;
import com.exel.customer.exception.CustomerNotFoundException;
import com.exel.customer.repository.CustomerInformationRepository;

@Component
public class CustomerInfoDetailsService implements UserDetailsService {

	@Autowired
	private CustomerInformationRepository customerInformationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//fetching customer from dataBase
		System.out.println("usrdetails");
		CustomerInformation optional = customerInformationRepository.findByCustomerName(username);
	
		if(optional!=null) {
			System.out.println(optional);
			CustomerInfoCustomerDetails customerInfoCustomerDetails= new CustomerInfoCustomerDetails(optional);
			System.out.println(customerInfoCustomerDetails);
		
			return customerInfoCustomerDetails;
			
		}
		throw new CustomerNotFoundException(CUSTOMER_NOT_FOUND);
     
	}

}
