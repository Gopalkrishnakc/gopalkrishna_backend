package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MaritalStatus {
UNMARRIED("UNMARRIED"),MARRIED("MARRIED"),DIVORCED("DIVORCED");
	private final String maritalStatus;
}
