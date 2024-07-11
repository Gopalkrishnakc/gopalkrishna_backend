package com.exel.customer.exceptionhandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exel.customer.exception.AddressNotFoundException;
import com.exel.customer.exception.CustomerNotFoundException;

@RestControllerAdvice
public class CustomerAdvice {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<String> noCustomerFoundHandler(RuntimeException exe) {
		return ResponseEntity.status(HttpStatus.OK).body(exe.getMessage());
	}

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<String> noAddressFound(RuntimeException exe) {
		return ResponseEntity.status(HttpStatus.OK).body(exe.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethosArgumentNotValidException(MethodArgumentNotValidException exception) {
	  Map<String, String> errors = new HashMap<>();
		List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
		allErrors.forEach(err -> {
			FieldError fieldError = (FieldError) err;
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		});

		return errors;

	}
}
