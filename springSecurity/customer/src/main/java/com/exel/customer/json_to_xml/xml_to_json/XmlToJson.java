package com.exel.customer.json_to_xml.xml_to_json;

import org.json.JSONObject;
import org.json.XML;

public class XmlToJson {
public static void main(String[] args) {
	String xmlData= "<customerAge>23</customerAge><customerPhone>7879854712</customerPhone><password>Dilip@76</password><email>dilip@gmail.com</email><customerName>Dilip</customerName>\r\n"
			+ "";
 
     JSONObject json= XML.toJSONObject(xmlData);
     System.out.println(json);
}
}
