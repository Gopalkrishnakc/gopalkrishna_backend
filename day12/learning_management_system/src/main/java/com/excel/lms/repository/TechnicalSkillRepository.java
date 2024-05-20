package com.excel.lms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.lms.entity.EmployeeSkills;

public interface TechnicalSkillRepository extends JpaRepository<EmployeeSkills, Integer> {
	Optional<EmployeeSkills> findBySkillTypeAndSkillRatingAndYearOfExperience(String skillType,double skillRating,Integer yearOfExperience);
}