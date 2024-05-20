package com.excel.lms.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name="employee_skills_info")
public class EmployeeSkills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id")
private  Integer id;
private String skillType;
private String yearOfExpirence;
private String skillRating;

@JoinTable(name="map_skills_employee",joinColumns = @JoinColumn(name="skills_id"),inverseJoinColumns = @JoinColumn(name="employee_id"))
@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private List<EmployeePrimaryInfo> employeesPrimaryInfo;
}
