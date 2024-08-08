package com.exel.customer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exel.customer.entity.CustomerInformation;

public interface CustomerInformationRepository extends JpaRepository<CustomerInformation, Integer> {
	
	Optional<CustomerInformation> findByCustomerId(Integer customerId);

	Optional<CustomerInformation> findByEmail(String email);

	List<CustomerInformation> findByCustomerPhoneOrCustomerIdOrEmailOrCustomerNameOrCustomerAge(String customerPhone,
			Integer customerId, String email, String customerName, Integer customerAge);

	Optional<CustomerInformation> findByCustomerPhoneOrCustomerIdOrEmailOrCustomerAge(String customerPhone,
			Integer customerId, String email, Integer customerAge);

	@Query("select c from CustomerInformation c where c.email=:email")
	CustomerInformation findByCustomerName(@Param("email") String email);
	
	
}
