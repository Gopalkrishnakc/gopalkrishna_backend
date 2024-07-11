package com.exel.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exel.customer.commonresponse.CommonResponse;
import com.exel.customer.dto.AdminDto;
import com.exel.customer.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/Admin", method = { RequestMethod.POST, RequestMethod.PUT })
public class AdminController {
	@Autowired
	private AdminService adminService;
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping(path = "/admin")
	ResponseEntity<CommonResponse<AdminDto>> adminAdd(@Valid @RequestBody AdminDto dto) {
		AdminDto adminAdded = adminService.adminAdd(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<AdminDto>builder().data(adminAdded)
				.message("Admin Added Successfull").isError(false).build());
	
	}
}
