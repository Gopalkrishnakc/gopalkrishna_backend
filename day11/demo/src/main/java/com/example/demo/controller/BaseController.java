package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static com.example.demo.constant.EmployeeConstants.EMPLOYEE_DELETED_MESSAGE;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
public class BaseController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/getall")
public ResponseEntity<List<EmployeeDto>>fetchAllEmployees(){
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employee){
		EmployeeDto addEmployee=employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(addEmployee);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto>  updateEmployee(@RequestBody EmployeeDto dto,@PathVariable("id") Integer id){
		EmployeeDto updatedEmployee=employeeService.updateEmployee(dto,id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestBody EmployeeDto dto){
		employeeService.deleteEmployee( dto);
		return ResponseEntity.status(HttpStatus.OK).body(EMPLOYEE_DELETED_MESSAGE);
	}
	@GetMapping("/get")
	public ResponseEntity<EmployeeDto> getEmployee(@RequestBody EmployeeDto dto){
		EmployeeDto getemployee=employeeService.getEmployee(dto);
			return ResponseEntity.status(HttpStatus.OK).body(getemployee);
		}
}
