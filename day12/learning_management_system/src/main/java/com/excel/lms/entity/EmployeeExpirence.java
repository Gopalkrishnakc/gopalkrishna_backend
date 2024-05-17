package com.excel.lms.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="employee_expirence_info")
public class EmployeeExpirence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="expirence_id")
private Integer id;
private String companyName;
private String yearsOfExpirence;
private LocalDate dateOfJoining;
private LocalDate dateOfReliving;
private String designation;
private String location;

@JoinColumn(name="employee_id")
@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private EmployeePrimaryInfo employee;
}
