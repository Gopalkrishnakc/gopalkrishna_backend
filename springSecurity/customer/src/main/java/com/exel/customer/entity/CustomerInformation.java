package com.exel.customer.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name="custmerInfo")
public class CustomerInformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer customerId;
private Integer customerAge;
@NotBlank(message = "Name is mandatory")
@Size(min=2, max=30)
private String customerName;
@NotBlank
@Pattern(regexp = "^[0-9]{10}$",message = "10 digits requied!!")
private String customerPhone;
@Email
@Column(unique=true)
private String email;
 
private String password;
private String roles;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "customerInfo")
private List<Address> address;
}
