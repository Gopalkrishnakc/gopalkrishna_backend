package day2;

public class Encapsulation {
 private int id;
 private String name;
 private  double sal;
 public void setId(int  id) {
	 this.id=id;
 }
 
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
public int getId() {
	return id;
}
public static void main(String[] args) {
	Encapsulation e=new Encapsulation();
	e.setId(11);
	e.getId();
}
}
