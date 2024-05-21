package com.excel.ims.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.excel.ims.commomrespose.CommonResponse;
import com.excel.ims.dto.UserDto;
import com.excel.ims.service.InventoryService;


@RestController
@RequestMapping(path = "/api/v1/inventory", method = { RequestMethod.POST, RequestMethod.PUT })
public class InventroryController {
	@Autowired
	private InventoryService inventoryService;
@PostMapping(path = "/user/register")
	  ResponseEntity<CommonResponse<String>> addUserInfo(@RequestBody UserDto dto){
		  String userAdded=inventoryService. addUserInfo(dto);
		  return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(userAdded)
					.message("User_INFO_SAVED").isError(false).build());
	  }
@PostMapping(path = "/user/login")
ResponseEntity<CommonResponse<String>> userLogin(@RequestBody UserDto dto){
	  String userAdded=inventoryService. userLogin(dto);
	  return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(userAdded)
				.message("Login Successfull").isError(false).build());
}
@GetMapping(path = "/user/get")
ResponseEntity<CommonResponse<UserDto>> userGet(@RequestBody UserDto dto){
	  UserDto userfetch=inventoryService.userGet(dto);
	  return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<UserDto>builder().data(userfetch)
				.message("fetchinig  Successfull").isError(false).build());
}
   @PutMapping(path="/user/put")
public ResponseEntity<CommonResponse<UserDto>> updateEmployee(@RequestBody UserDto dto){
	UserDto updatedUser = inventoryService.updateUser(dto);
	return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<UserDto>builder().data(updatedUser)
			.isError(false).message("USER_UPDATE_SUCCESS").build());
   }


}
