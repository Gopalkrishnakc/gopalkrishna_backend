package onetoone.entity;

import jakarta.persistence.Column;
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
@Table(name="student")
public class Student {
	
@Id	
@GeneratedValue(strategy =GenerationType.AUTO)
@Column(name="student_id")
private int stuid;
@Column(name="student_name")
private String stuName;
@Column(name="student_age")
private int age;
@OneToOne
private MarksCard markscard;

}
