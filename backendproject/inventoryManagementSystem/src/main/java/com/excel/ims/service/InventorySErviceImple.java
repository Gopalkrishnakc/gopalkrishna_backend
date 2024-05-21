package com.excel.ims.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.User;
import com.excel.ims.repository.UserRepository;
import com.excel.ims.utils.ObjectUtils;

@Service
public class InventorySErviceImple implements InventoryService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public String addUserInfo(UserDto dto) {
		if(!userRepository.findByEmail(dto.getEmail()).isPresent()) {
			User user=ObjectUtils.userDtoToEntitiy( dto);
			user.setAdmin(true);
			User user1=userRepository.save(user);
			return user.getEmail();
		}
		return "user is already present";
	}

	@Override
	public String userLogin(UserDto dto) {
		 Optional<User> optional = userRepository.findByEmail(dto.getEmail());
	       if (optional.isPresent()) {
	           User user = optional.get();
	           if (user.getPassword().equals(dto.getPassword())) {
	               return user.getUsername();
	           } else {
	               return "Incorrect password";
	           }
	       }
	       return "Invalid username"; 
	}

	@Override
	public UserDto userGet(UserDto dto) {
		Optional<User> optional=userRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			User user=optional.get();
			UserDto user1=ObjectUtils.userEntityToDto(user);
			return user1;
		}
		return null;
	}

	@Override
	public UserDto updateUser(UserDto dto) {
		Optional<User> optional=userRepository.findByEmail(dto.getEmail());
		if(optional.isPresent()) {
			User user=optional.get();
			user=ObjectUtils.updateValues(user,dto);
			User save=userRepository.save(user);
			return ObjectUtils.userEntityToDto(save);
		}
		return null;
	}

	

}
