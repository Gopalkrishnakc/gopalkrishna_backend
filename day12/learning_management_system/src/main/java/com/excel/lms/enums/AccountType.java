package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AccountType {
SAVINGS("SAVINGS"), CURRENT("CURRENT"), JOINT("JOINT");
	private final String types;
}
