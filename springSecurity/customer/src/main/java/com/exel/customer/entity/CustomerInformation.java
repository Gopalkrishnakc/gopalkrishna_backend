package com.exel.customer.entity;

import java.util.List;


import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="custmerInfo")
public class CustomerInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer customerId;
private Integer customerAge;

private String customerName;

private String customerPhone;

private String email;
 
private String password;
private String roles;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "customerInfo")
private List<Address> address;
}
