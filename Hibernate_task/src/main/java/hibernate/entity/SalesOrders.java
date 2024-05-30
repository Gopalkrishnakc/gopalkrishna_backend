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
public class SalesOrders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int order_id;
@ManyToOne
private UserTable users;
private String customer;
private String order_date;
private String status;
private String created_at;
}
