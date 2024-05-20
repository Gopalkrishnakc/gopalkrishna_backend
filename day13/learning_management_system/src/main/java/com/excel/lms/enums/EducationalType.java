package com.excel.lms.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum EducationalType {
	UNDERGRADUATE("UNDERGRADUATE"),GRADUATE("GRADUATE"),PHD("PHD");
	private final String address;
}
