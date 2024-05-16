package com.excel.lms.entity;



import com.excel.lms.enums.ContactType;

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
@Table(name="employee_contact_info")
public class EmployeeContact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Integer id;
	@Enumerated(EnumType.STRING)
	private ContactType contactType;
	private String contactNo;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private EmployeePrimaryInfo employee;

}
