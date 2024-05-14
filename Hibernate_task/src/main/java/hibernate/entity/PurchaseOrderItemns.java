package hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PurchaseOrderItemns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_item_id;
	@OneToOne
	PurchaseOrders purchaseorders;
	@OneToOne
	InventoryTable inventoryItems;

	private int quantity;
	private double unit_price;

}
