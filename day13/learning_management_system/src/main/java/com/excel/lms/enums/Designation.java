package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum  Designation {
 TRAINEE("TRAINEE"), MENTOR("MENTOR"), DEVELOPER("DEVELOPER");
	private final String designation;
}
