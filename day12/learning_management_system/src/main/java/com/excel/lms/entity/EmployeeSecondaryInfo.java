package com.excel.lms.entity;



import com.excel.lms.enums.MaritalStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="employee_secondary_info")
public class EmployeeSecondaryInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="secondary_id")
private Integer id;
private String panNo;
private String aadharNo;
private String fatherName;
private String motherName;
private String spouseName;
@Enumerated(EnumType.STRING)
private MaritalStatus maritalStatus;
private String passportNo;
}
