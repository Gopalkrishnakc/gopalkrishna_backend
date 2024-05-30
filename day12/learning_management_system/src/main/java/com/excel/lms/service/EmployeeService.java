package com.excel.lms.service;

import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ExpirenceListDto;
import com.excel.lms.dto.TechicalSkillsListDto;

public interface EmployeeService {

	EmployeePrimaryInfoDto addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto);

	String addEducationDetails(EducationListDto dto);

	String addEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto);

	String addBankInfo(EmployeeBankDetailsDto dto);

	String addAddressDetails(AddressListDto dto);

	

	String addExpirencesDetails(ExpirenceListDto dto);

	String addContactsDetails(ContactListDto dto);

	String saveTechnicalSkills(TechicalSkillsListDto dto);









}
