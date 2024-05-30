package com.excel.spring1.constructor;

public class Employee {
private int id;
private String name;
private Address address;

public Employee() {
	super();
}

public Employee(int id, String name, Address address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}

@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
}

}
