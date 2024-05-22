package com.excel.ims.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class PurchaseOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer orderId;
private String supplier;
private LocalDate orderDate;
private String status;
private String createdAt;

@JoinColumn(name="User_id")
@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
private User userTable;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "purchaseOrders")
private List<PurchaseOrderItems> purchaseOrdersItems;
}