package hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StockMovement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int movement_Id;
	
private int item_id;
private String Movement_type;
private int quantity;
private String date;
private String note;

@ManyToOne
private InventoryTable it;
}
