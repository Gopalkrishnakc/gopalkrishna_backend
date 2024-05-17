package com.excel.lms.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.excel.lms.constants.EmployeeConstants.EMPLOYEE_PRIMARY_INFO_SAVED;
import com.excel.lms.commonresponse.CommonResponse;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/v1/employee", method = { RequestMethod.POST, RequestMethod.PUT })
public class EmployeeRegisterController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/pinfo")
	public ResponseEntity<CommonResponse<EmployeePrimaryInfoDto>> addEmployeePrimaryInfo(
			@RequestBody EmployeePrimaryInfoDto dto) {
		EmployeePrimaryInfoDto added = employeeService.addEmployeePrimaryInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(
				CommonResponse.<EmployeePrimaryInfoDto>builder().data(added).message(EMPLOYEE_PRIMARY_INFO_SAVED)
				.isError(false).build());
	}

}
