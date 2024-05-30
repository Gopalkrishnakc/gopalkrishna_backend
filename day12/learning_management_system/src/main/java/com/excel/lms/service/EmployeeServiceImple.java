package com.excel.lms.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excel.lms.dto.AddressListDto;
import com.excel.lms.dto.ContactListDto;
import com.excel.lms.dto.EducationListDto;
import com.excel.lms.dto.EmployeeBankDetailsDto;
import com.excel.lms.dto.EmployeePrimaryInfoDto;
import com.excel.lms.dto.EmployeeSecondaryInfoDto;
import com.excel.lms.dto.ExpirenceListDto;
import com.excel.lms.dto.TechicalSkillsListDto;
import com.excel.lms.entity.EmployeeAddressInfo;
import com.excel.lms.entity.EmployeeBankDetails;
import com.excel.lms.entity.EmployeeContact;
import com.excel.lms.entity.EmployeeEducationDetails;
import com.excel.lms.entity.EmployeeExpirence;
import com.excel.lms.entity.EmployeePrimaryInfo;
import com.excel.lms.entity.EmployeeSecondaryInfo;
import com.excel.lms.entity.EmployeeSkills;
import com.excel.lms.repository.EmployeeRepository;
import com.excel.lms.util.ObjectUtils;


@Service
public class EmployeeServiceImple implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeePrimaryInfoDto addEmployeePrimaryInfo(EmployeePrimaryInfoDto dto) {

		if (!employeeRepository.findByEmployeeId(dto.getEmployeeId()).isPresent()) {
			EmployeePrimaryInfo employee1 = ObjectUtils.dtoToEntity(dto);
			EmployeePrimaryInfo employee = employeeRepository.save(employee1);
			return EmployeePrimaryInfoDto.builder().employeeId(employee.getEmployeeId()).build();
		}
		return null;
	}

	@Override
	public String addEducationDetails(EducationListDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo primaryInfo = optional.get();
			List<EmployeeEducationDetails> educationDetails = ObjectUtils.educationDtoToEntity(dto.getEducation());
			primaryInfo.setEducationDetails(educationDetails);
			educationDetails.stream().forEach(x -> x.setEmployeePrimaryInfo(primaryInfo));
			return employeeRepository.save(primaryInfo).getEmployeeId();
		}
		return null;
	}

	@Override
	public String addEmployeeSecondaryInfo(EmployeeSecondaryInfoDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if (optional.isPresent()) {
			EmployeePrimaryInfo emp = optional.get();
			/* This if part is for saving */
			if (emp.getSecondaryEmployeeInfo() == null) {
				EmployeeSecondaryInfo employeeSecondaryInfo = ObjectUtils.dtoToEntity(dto);
				/* save to primaryEmployee */
				emp.setSecondaryEmployeeInfo(employeeSecondaryInfo);
				/* again save to secondaryEmployee */
				employeeSecondaryInfo.setEmployeePrimaryInfo(emp);
				/* here we save all data to PrimaryEmployee then get emp_id */
				return employeeRepository.save(emp).getEmployeeId();
			}
			/*
			 * This else part is only if we want to update any of field, it means not null
			 */
			else {
				/* here we are getting from employeePrimaryInfo, if already data is stored */
				EmployeeSecondaryInfo secondaryInfo = emp.getSecondaryEmployeeInfo();
				/* here we are setting all fields */
				secondaryInfo.setPanNo(dto.getPanNo());
				secondaryInfo.setAadharNo(dto.getAadharNo());
				secondaryInfo.setFatherName(dto.getFatherName());
				secondaryInfo.setMotherName(dto.getMotherName());
				secondaryInfo.setMaritalStatus(dto.getMaritalStatus());
				secondaryInfo.setPassportNo(dto.getPassportNo());
				secondaryInfo.setSpouseName(dto.getSpouseName());

				return employeeRepository.save(emp).getEmployeeId();
			}
		}
		return null;
	}

	@Override
	public String addBankInfo(EmployeeBankDetailsDto dto) {
		Optional<EmployeePrimaryInfo> optional = employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if (optional.isPresent()) {
			EmployeePrimaryInfo emp = optional.get();
			if (emp.getEmployeeAccount() == null) {
				EmployeeBankDetails employeeAccount = ObjectUtils.dtoToEntity(dto);
				emp.setEmployeeAccount(employeeAccount);
				employeeAccount.setEmployeePrimaryInfo(emp);
				return employeeRepository.save(emp).getEmployeeId();
			} else {
				EmployeeBankDetails account = emp.getEmployeeAccount();
				account.setAccountNo(dto.getAccountNo());
				account.setAccountType(dto.getAccountType());
				account.setBankName(dto.getBankName());
				account.setBranch(dto.getBranch());
				account.setIfsc(dto.getIfsc());
				account.setState(dto.getState());
				return employeeRepository.save(emp).getEmployeeId();
			}
		}
		return null;
	}

	@Override
	public String addAddressDetails(AddressListDto dto) {
		Optional<EmployeePrimaryInfo>optional =employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo employee=optional.get();
			List<EmployeeAddressInfo> addressDetails= ObjectUtils.addressDtoToEntity(dto.getAddress());
			employee.setEmployeeAddress(addressDetails);
			addressDetails.stream().forEach(x->x.setEmployeePrimaryInfo(employee));
			return employeeRepository.save(employee).getEmployeeId();
		}
		return null;
	}

	@Override
	public String addExpirencesDetails(ExpirenceListDto dto) {
		Optional<EmployeePrimaryInfo>optional =employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo primaryInfo=optional.get();
			List<EmployeeExpirence> expirences=ObjectUtils.expirencesDtoToEntity(dto.getExpirences());
			primaryInfo.setEmployeeExpirences(expirences);
			expirences.stream().forEach(x->x.setEmployeePrimaryInfo(primaryInfo));
			return employeeRepository.save( primaryInfo).getEmployeeId();
		}
		return null;
	}

	@Override
	public String addContactsDetails(ContactListDto dto) {
		Optional<EmployeePrimaryInfo>optional =employeeRepository.findByEmployeeId(dto.getEmployeeId());
		if(optional.isPresent()) {
			EmployeePrimaryInfo primaryInfo=optional.get();
			List<EmployeeContact> contacts=ObjectUtils.contactsDtoToEntity(dto.getContacts());
			primaryInfo.setEmployeeContacts(contacts);
			contacts.stream().forEach(x->x.setEmployeePrimaryInfo(primaryInfo));
			return employeeRepository.save( primaryInfo).getEmployeeId();
		}
		return null;
	}

	public String saveTechnicalSkills(TechicalSkillsListDto dto) {
		Optional<EmployeePrimaryInfo> empOptional=employeeRepository.findByEmployeeId(dto.getEmployeeId());

		if(empOptional.isPresent()) {
			EmployeePrimaryInfo employee=empOptional.get();

			List<EmployeeSkills> skills=dto.getTechnicalSkills().stream().map(skill ->{
				Optional<EmployeeSkills> optional=technicalSkillRepository.findBySkillTypeAndSkillRatingAndYearOfExperience(skill.getSkillType(), skill.getSkillRating(),
						skill.getYearOfExperience());
				return optional.isPresent()? optional.get() : ObjectUtil.dtoToSkillEntity(skill);

			}).collect(Collectors.toList());

			if(employee.getEmployeeSkills()!=null) {
				employee.getEmployeeSkills().clear();
			}
			skills.stream().forEach(x -> {
				if(!x.getEmployeesPrimaryInfo().contains(employee))
					x.getEmployeesPrimaryInfo().add(employee);
			});
			employee.setEmployeeSkills(skills);
			employeeRepository.save(employee);
			return employee.getEmployeeId();
		}
		return null;
	}
	
}
