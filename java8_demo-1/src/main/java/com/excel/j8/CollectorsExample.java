package com.excel.j8;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;  
import java.util.Map;  
import java.util.stream.Collectors; 
public class CollectorsExample {
public static void main(String[] args) {
	 // Example list of people's names  
    List<String> names = Arrays.asList("John", "Sara", "Mark", "Sara", "Chris", "Paula");  
    // Collecting into a List  
    List<String> nameList = names.stream().collect(Collectors.toList());  
    System.out.println("Names List: " + nameList);  
    // Grouping names by the first letter  
    Map<Character, List<String>> namesByFirstLetter = names.stream()  
        .collect(Collectors.groupingBy(name -> name.charAt(0)));  
    System.out.println("Names Grouped by First Letter: " + namesByFirstLetter);  
    // Joining names into a single string separated by commas  
    String allNames = names.stream().collect(Collectors.joining(", "));  
    System.out.println("All Names Joined: " + allNames);  
    // Counting the distinct names  
    long distinctNameCount = names.stream().distinct().count();  
    System.out.println("Distinct Names Count: " + distinctNameCount);  
    
    String str="gopalkrishna";
    String encodedValue=Base64.getEncoder().encodeToString(str.getBytes());
    System.out.println(encodedValue);
    byte[] decoddedValue=Base64.getDecoder().decode(encodedValue);
    String decodedString = new String(decoddedValue);  
    System.out.println(decodedString);
}
}
