package com.exel.customer.json_to_xml.xml_to_json;

import org.json.JSONObject;
import org.json.XML;



public class JsonToXml {
public static void main(String[] args) {
	String json_object="{\r\n"
			+ "    \"customerAge\":23,\r\n"
			+ "    \"email\":\"dilip@gmail.com\",\r\n"
			+ "    \"customerPhone\":\"7879854712\",\r\n"
			+ "    \"customerName\":\"Dilip\",\r\n"
			+ "    \"password\":\"Dilip@76\"\r\n"
			+ "}";
	JSONObject obj=new JSONObject(json_object);
	String xmlData=XML.toString(obj);
	System.out.println(xmlData);
}
}
