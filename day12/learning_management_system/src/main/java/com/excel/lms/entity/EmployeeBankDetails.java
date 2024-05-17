package com.excel.lms.entity;



import com.excel.lms.enums.AccountType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name="employee_bank_info")
public class EmployeeBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bank_id")
private Integer id;
private String bankName;
private String branch;
private String accountNo;
@Enumerated(EnumType.STRING)
private AccountType accountType;
@Column(name="IFSC")
private String ifsc;
private String state;

@JoinColumn(name="employee_id")
@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private EmployeePrimaryInfo employee;
}
