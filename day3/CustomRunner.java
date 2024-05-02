package day3;

import java.util.ArrayList;
import java.util.Iterator;

public class CustomRunner {

	public static void main(String[] args) {
	ArrayList<Integer> list=new ArrayList<Integer>();
     list.add(1);
     list.add(2);
     list.add(3);
     list.add(4);
     
	list.forEach(ele->{
		System.out.println(ele);
	});
	System.out.println();
	list.forEach(System.out::println);
	
	Iterator<Integer> iterator=list.iterator();
	
	
	}
	
	
	

}
