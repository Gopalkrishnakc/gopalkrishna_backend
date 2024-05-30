package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InventoryTable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	
private int item_Id;
private String name;
private String description;
private String category;
private double unit_price;
private int quantity_on_hand;
private String reorder_point;
private String created_at;
@OneToMany(mappedBy = "it")
private List<StockMovement> list=new ArrayList<StockMovement>();
}
