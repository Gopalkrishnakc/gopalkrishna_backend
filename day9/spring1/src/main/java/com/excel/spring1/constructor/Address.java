package com.excel.spring1.constructor;

public class Address {
private int pin;
private String addressName;
public Address(int pin, String addressName) {
	super();
	this.pin = pin;
	this.addressName = addressName;
}
@Override
public String toString() {
	return "Address [pin=" + pin + ", addressName=" + addressName + "]";
}

}
