package com.excel.j8;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class DateMethod {
 static LocalDate date= LocalDate.now();
 public static void main(String[] args) {
	 System.out.println(date);
	LocalDate future=date.plusDays(3);
	System.out.println(future);
	DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yy");
    String formattedDate = future.format(formatter);  
    System.out.println( formattedDate );
    String dateString = "25-12-2024";  
    LocalDate parsedDate = LocalDate.parse(dateString, formatter);  
    System.out.println("Parsed Date: " + parsedDate);  
}
}
