package com.excel.lms.entity;

import java.time.LocalDate;

import com.excel.lms.enums.EducationalType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name="employee_education_info")
public class EmployeeEducationDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="education_id")
private Integer id;
@Enumerated(EnumType.STRING)
private EducationalType educationType;
private Double pecentage;
private String specilization;
private String instituteName;
private String universityName;
private String district;
private String state;
private LocalDate yearOfPassing;

@ManyToOne(fetch = FetchType.EAGER)
private EmployeePrimaryInfo employee;

}
