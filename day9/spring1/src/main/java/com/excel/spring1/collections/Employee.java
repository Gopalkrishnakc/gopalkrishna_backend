package com.excel.spring1.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {
private String name;
private List<String>phone;
private Set<String>skills;
private Map<String, String>nominees;
public Employee() {
	super();
}
@Override
public String toString() {
	return "Employee [name=" + name + ", phone=" + phone + ", skills=" + skills + ", nominees=" + nominees + "]";
}
public Employee(String name, List<String> phone, Set<String> skills, Map<String, String> nominees) {
	super();
	this.name = name;
	this.phone = phone;
	this.skills = skills;
	this.nominees = nominees;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<String> getPhone() {
	return phone;
}
public void setPhone(List<String> phone) {
	this.phone = phone;
}
public Set<String> getSkills() {
	return skills;
}
public void setSkills(Set<String> skills) {
	this.skills = skills;
}
public Map<String, String> getNominees() {
	return nominees;
}
public void setNominees(Map<String, String> nominees) {
	this.nominees = nominees;
}
}
