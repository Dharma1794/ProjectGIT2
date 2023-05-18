package org.sample;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;




public class SampleSingleFlight {
public static void main(String[] args) throws IOException, ParseException {
	// path of file
	FileReader fileReader = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\ApiSample\\src\\test\\resources\\JsonFile.json");
	
	// object for json file
	JSONParser parser = new JSONParser();
	
	// pass json file
	Object parse = parser.parse(fileReader);
	
	// class cast
	JSONObject jsonObject = (JSONObject) parse;
	System.out.println(jsonObject);
	
	Object object = jsonObject.get("data");
	
	JSONObject jsonObject2 = (JSONObject) object;
	
	Object object2 = jsonObject2.get("id");
	System.out.println(object2);
	
	Object object3 = jsonObject2.get("flightName");
	System.out.println(object3);
	
	Object object4 = jsonObject2.get("Country");
	System.out.println(object4);
	
	Object object5 = jsonObject2.get("Destinations");
	System.out.println(object5);
	
	Object object6 = jsonObject2.get("URL");
	System.out.println(object6);
	
	Object object7 = jsonObject2.get("Created_Date");
	System.out.println(object7);
	
	Object object8 = jsonObject2.get("Updated_Date");
	System.out.println(object8);
	
	//support
	Object object1 = jsonObject.get("support");
	JSONObject jsonObject3 =  (JSONObject) object1;
	
	Object object9 = jsonObject3.get("url");
	System.out.println(object9);
	
	Object object10 = jsonObject3.get("text");
	System.out.println(object10);
	
	
	
	
	
	
	
	
	
	
	
	
}
}
