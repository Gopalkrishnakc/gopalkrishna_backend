package com.exel.customer.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer addressId;
  private String addressType;
  private String city;
  private String place;
  private String district;
  private String state;
  private String pincode;
  
  @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
  private CustomerInformation customerInfo;
}
