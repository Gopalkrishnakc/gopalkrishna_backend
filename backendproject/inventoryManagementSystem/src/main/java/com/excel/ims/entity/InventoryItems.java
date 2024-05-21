package com.excel.ims.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class InventoryItems {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer itemId;
private String itemname;
private String description;
private String category;
private String unit_price;
private String quantityOnHand;
private String reorderPoint;
private String created_at;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "inventoryItems")
private List<PurchaseOrderItems> purchaseOrdersItems;
}
