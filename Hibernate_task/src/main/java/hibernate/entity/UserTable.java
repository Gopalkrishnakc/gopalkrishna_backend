package hibernate.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User_table")
public class UserTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int user_Id;
private String userNAme;
private String email;
private String password;
private boolean is_admin;
private String created_at;
@OneToMany(mappedBy = "users")
private List<PurchaseOrders>list=new ArrayList<PurchaseOrders>();
@OneToMany(mappedBy = "users")
private List<SalesOrders>list1=new ArrayList<SalesOrders>();
}
