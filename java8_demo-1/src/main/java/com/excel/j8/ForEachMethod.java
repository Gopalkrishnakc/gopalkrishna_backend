package com.excel.j8;

import java.util.HashMap;
import java.util.Map;

public class ForEachMethod {
public static void main(String[] args) {
	Map<Integer,Object> hash=new HashMap<>();
	hash.put(1, "one");
	hash.put(2, "two");
	hash.put(3, "three");
	hash.forEach((key,value)-> System.out.println("Key: " + key + ", Value: " + value)); 
}
}
