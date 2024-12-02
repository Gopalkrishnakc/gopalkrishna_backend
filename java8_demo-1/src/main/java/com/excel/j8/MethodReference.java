package com.excel.j8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class MethodReference {
static String str="jan";

public static void main(String[] args) {
	List<String> lang=Arrays.asList("java","html","css");
	lang.stream().map(String::toUpperCase).collect(Collectors.toList());
	lang.forEach(System.out::println);
}
}
