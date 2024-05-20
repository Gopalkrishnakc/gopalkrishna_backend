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
import static com.excel.lms.constants.EmployeeConstants.EMPLOYEE_EDUCATION_INFO_SAVED;
import static com.excel.lms.constants.EmployeeConstants.EMPLOYEE_SECONDARY_INFO_SAVED;
import static com.excel.lms.constants.EmployeeConstants.EMPLOYEE_ACCOUNT_INFO_SAVED;
import static com.excel.lms.constants.EmployeeConstants.EMPLOYEE_ADDRESS_INFO_SAVED;
import static com.excel.lms.constants.EmployeeConstants.EMPLOYEE_EXPIRENCES_INFO_SAVED;
import static com.excel.lms.constants.EmployeeConstants.EMPLOYEE_CONTACTS_INFO_SAVED;
import com.excel.lms.commonresponse.CommonResponse;
import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ExpirenceListDto;
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
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<EmployeePrimaryInfoDto>builder().data(added)
				.message(EMPLOYEE_PRIMARY_INFO_SAVED).isError(false).build());

	}
	@PostMapping(path = "/secinfo")
	public ResponseEntity<CommonResponse<String>> addEmployeeSecondaryInfo(
			@RequestBody EmployeeSecondaryInfoDto dto) {
		String  secData = employeeService.addEmployeeSecondaryInfo(dto);
		return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(secData)
				.message(EMPLOYEE_SECONDARY_INFO_SAVED).isError(false).build());

	}
	 @PostMapping(path="/account")
	public ResponseEntity<CommonResponse<String>> addBankInfo(EmployeeBankDetailsDto dto){
		 String account=employeeService.addBankInfo(dto);
		 return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(account)
					.message(EMPLOYEE_ACCOUNT_INFO_SAVED).isError(false).build());
	 }

      @PostMapping(path="/educationdetails")
     public ResponseEntity<CommonResponse<String>>addEducationDetails(@RequestBody EducationListDto dto){
     String qulifications=employeeService.addEducationDetails(dto);
	

		return  ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(qulifications)
				.message(EMPLOYEE_EDUCATION_INFO_SAVED).isError(false).build()); 
	}
      @PostMapping(path="/address")
      public ResponseEntity<CommonResponse<String>>addAddressDetails(@RequestBody AddressListDto dto){
      String address=employeeService.addAddressDetails(dto);
 		return  ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(address)
 				.message(EMPLOYEE_ADDRESS_INFO_SAVED).isError(false).build()); 
 	}
      @PostMapping(path="/expirences")
      public ResponseEntity<CommonResponse<String>>addExpirencesDetails(@RequestBody ExpirenceListDto dto){
      String expirences=employeeService.addExpirencesDetails(dto);
 		return  ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(expirences)
 				.message(EMPLOYEE_EXPIRENCES_INFO_SAVED).isError(false).build()); 
 	}
      @PostMapping(path="/contacts")
      public ResponseEntity<CommonResponse<String>>addContactsDetails(@RequestBody ContactListDto dto){
      String contacts=employeeService.addContactsDetails(dto);
 		return  ResponseEntity.status(HttpStatus.OK).body(CommonResponse.<String>builder().data(contacts)
 				.message(EMPLOYEE_CONTACTS_INFO_SAVED).isError(false).build()); 
 	}
      
}
