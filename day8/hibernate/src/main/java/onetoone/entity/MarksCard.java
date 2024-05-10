package onetoone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name="progressCard")
public class MarksCard {
@Id	
@GeneratedValue(strategy =GenerationType.AUTO )
private int id;
private String grade;
private double marks;
@OneToOne(mappedBy="markscard")
private Student student;
}
