package com.exel.customer.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exel.customer.dto.AdminDto;
import com.exel.customer.entity.Admin;
import com.exel.customer.exception.CustomerNotFoundException;
import com.exel.customer.repository.AdminRepository;
import com.exel.customer.utils.UtilsObject;

@Service
public class AdminServiceImplementation implements AdminService{
	@Autowired
	private AdminRepository adminRepository;
	@Override
	public AdminDto adminAdd(AdminDto dto) {
		Optional<Admin> optional = adminRepository.findByEmail(dto.getEmail());
		if (!optional.isPresent()) {
			Admin admin = UtilsObject.itemsDtoToEntity(dto);
			admin.setAdmin(true);
			adminRepository.save(admin);

			return AdminDto.builder().adminame(admin.getAdminame()).email(admin.getEmail())
					.adminId(admin.getAdminId()).build();
		}
		throw new CustomerNotFoundException("ADMIN_NOT_FOUND");
	}

}