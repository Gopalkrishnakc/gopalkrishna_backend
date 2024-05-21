package com.excel.ims.utils;

import com.excel.ims.dto.UserDto;
import com.excel.ims.entity.User;

public class ObjectUtils {

	public static User userDtoToEntitiy(UserDto dto) {
	
		return User.builder().username(dto.getUserName())
				.email(dto.getEmail()).password(dto.getPassword())
				.createdAt(dto.getCreatedAt()).build();
	}

	public static UserDto userEntityToDto(User user) {
	
		return UserDto.builder().userId(user.getUserId())
				.userName(user.getUsername()).email(user.getEmail())
				.password(user.getPassword()).createdAt(user.getCreatedAt()).isAdmin(user.isAdmin()).build();
	}

	public static User updateValues(User user, UserDto dto) {
		
			

			user.setUsername(dto.getUserName());
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			user.setCreatedAt(dto.getCreatedAt());
			user.setAdmin(user.isAdmin());
			return user;


		
	}

}


