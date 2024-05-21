package com.excel.ims.service;

import com.excel.ims.dto.UserDto;

public interface InventoryService {

	String addUserInfo(UserDto dto);

	String userLogin(UserDto dto);

	public UserDto userGet(UserDto dto);

	UserDto updateUser(UserDto dto);



}
