package com.excel.lms.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.excel.lms.dto.EmployeeAddressInfoDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeeContactDto;
import com.excel.lms.dto.EmployeeEducationDetailsDto;
import com.excel.lms.dto.EmployeeExpirenceDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.EmployeeSkillsDto;
import com.excel.lms.dto.TechicalSkillsListDto;
import com.excel.lms.entity.EmployeeBankDetails;
import com.excel.lms.entity.EmployeeContact;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExpirence;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.EmployeeSkills;
import com.excel.lms.entity.EmployeeAddressInfo;

public class ObjectUtils {
private ObjectUtils() {
	
}

public static EmployeePrimaryInfo dtoToEntity( EmployeePrimaryInfoDto dto) {
	return EmployeePrimaryInfo.builder().id(dto.getId()).employeeId(dto.getEmployeeId())
			.dateOfJoining(dto.getDateOfJoining()).dateOfBirth(dto.getDateOfBirth())
			.email(dto.getEmail()). bloodGroup(dto.getBloodGroup())
			.employeeName(dto.getEmployeeName())
			.nationality(dto.getNationality())
			.gender(dto.getGender()).designation(dto.getDesignation())
			.employeeStatus(dto.getEmployeeStatus()).build();
}
public static EmployeeSecondaryInfo dtoToEntity(EmployeeSecondaryInfoDto dto) {

	return EmployeeSecondaryInfo.builder().panNo(dto.getPanNo())
			.aadharNo(dto.getAadharNo()).fatherName(dto.getFatherName())
			.motherName(dto.getMotherName()).spouseName(dto.getSpouseName())
			.maritalStatus(dto.getMaritalStatus()).passportNo(dto.getPassportNo())
			.build();
}
public static EmployeeBankDetails dtoToEntity(EmployeeBankDetailsDto dto) {

	return EmployeeBankDetails.builder().accountNo(dto.getAccountNo())
			.bankName(dto.getBankName()).accountType(dto.getAccountType())
			.ifsc(dto.getIfsc()).branch(dto.getBranch()).state(dto.getState()).build();
}

public static List<EmployeeEducationDetails> educationDtoToEntity(List<EmployeeEducationDetailsDto> list) {
	return list.stream().map(edu-> EmployeeEducationDetails.builder()
			.educationType(edu.getEducationType()).id(edu.getId())
			.pecentage(edu.getPecentage())
			.specilization(edu.getSpecilization()).instituteName(edu.getInstituteName())
			.instituteName(edu.getInstituteName()).universityName(edu.getUniversityName())
			.district(edu.getDistrict()).state(edu.getState())
			.yearOfPassing(edu.getYearOfPassing()).build()).collect(Collectors.toList());
			
}

public static List<EmployeeAddressInfo> addressDtoToEntity(List<EmployeeAddressInfoDto> address) {
	
	return address.stream().map(ad->EmployeeAddressInfo.builder().id(ad.getId()).addressType(ad.getAddressType())
			.doorNo(ad.getDoorNo()).street(ad.getStreet()).locality(ad.getLocality())
			.city(ad.getCity()).locality(ad.getLocality())
			.landMark(ad.getLandMark()).pin(ad.getPin())
			.build()).collect(Collectors.toList());
}

public static List<EmployeeExpirence> expirencesDtoToEntity(List<EmployeeExpirenceDto> expirences) {
	
	return  expirences.stream().map(e->EmployeeExpirence.builder().id(e.getId()).companyName(e.getCompanyName())
			.dateOfJoining(e.getDateOfJoining()).dateOfReliving(e.getDateOfReliving())
			.yearsOfExpirence(e.getYearsOfExpirence()).designation(e.getDesignation())
			.location(e.getLocation()).build()).collect(Collectors.toList());
}

public static List<EmployeeContact> contactsDtoToEntity(List<EmployeeContactDto> contacts) {
	
	return contacts.stream().map(c->EmployeeContact.builder().id(c.getId()).contactNo(c.getContactNo())
			.contactType(c.getContactType()).build()).collect(Collectors.toList());
}
public static EmployeeSkills dtoToSkillEntity(EmployeeSkillsDto skill) {
	return EmployeeSkills.builder().skillType(skill.getSkillType()).yearOfExpirence(skill.getYearOfExpirence()).skillRating(skill.getSkillRating())
			.employeesPrimaryInfo(new ArrayList<>())
			.build();

}
}
