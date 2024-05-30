package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ContactType {
PERSONAL("PERSONAL"),TELEPHONE("TELEPHONE");
	private final String contact;
}
