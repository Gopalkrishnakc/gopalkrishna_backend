package com.excel.j8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
public class Optional1 {
public static void main(String[] args) {
	List<Object>data=Arrays.asList(1,"aman",'w');
	Optional<Object> optional=Optional.ofNullable(data);
	if(optional.isPresent()) {
		data.forEach(System.out::println);
	}
}
}
