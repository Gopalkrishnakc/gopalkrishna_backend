package onetomany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name="laptopData")
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int lapid;
private String brand;
private String serialNum;
@ManyToOne(cascade = CascadeType.ALL)
private Student1 student;
}
