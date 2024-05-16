package com.example.demo.service;



import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.exception.NoEmployeeFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.util.EmployeeUtil;
import static com.example.demo.constant.EmployeeConstants.EMPLOYEE_NOT_FOUND;
@Service
public class EmployeeServiceImplement implements EmployeeService {
	@Autowired
    private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto addEmployee(EmployeeDto dto) {
	Employee employee=Employee.builder().firstName(dto.getFirstName())
			.lastName(dto.getLastName()).aadharNo(dto.getAadharNo())
			.panNo(dto.getPanNo()).employeeNo(dto.getEmployeeNo()).build();
		
	Employee save=employeeRepository.save(employee);
			
	return EmployeeUtil.entityToDto(save);
	}
	@Override
	public void deleteEmployee(EmployeeDto dto) {
		Optional<Employee>optional=employeeRepository.findById(dto.getId());
		if(optional.isPresent()) {
			employeeRepository.delete(optional.get());
		}
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		
		return employeeRepository.findAll().stream().map(e-> EmployeeDto.builder().id(e.getId()).aadharNo(e.getAadharNo()).firstName(e.getFirstName()).lastName(e.getLastName()).panNo(e.getPanNo()).employeeNo(e.getEmployeeNo()).build()).toList();
	}
	@Override
	public EmployeeDto updateEmployee(EmployeeDto dto, Integer id) {
		Optional<Employee>optional=employeeRepository.findById(id);
		if(optional.isPresent()) {
		Employee emp=optional.get();
		emp.setFirstName(dto.getFirstName());
		Employee save=employeeRepository.save(emp);
		return EmployeeUtil.entityToDto(save);
		}
		else
		throw new NoEmployeeFoundException("EMPLOYEE_NOT_FOUND");

}
	@Override
	public EmployeeDto getEmployee(EmployeeDto dto) {
		Optional<Employee>optional=employeeRepository.findById(dto.getId());
		if(optional.isPresent()) {
		Employee get=optional.get();
		
		return EmployeeUtil.entityToDto(get);
	}else
		return null;
		
	}
}
