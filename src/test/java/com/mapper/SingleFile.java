package com.mapper;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SingleFile {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
	File file = new File("C:\\Users\\Admin\\eclipse-workspace\\ApiSample\\src\\test\\resources\\SingleFlight.json");
	ObjectMapper mapper = new ObjectMapper();
	PojoRoot readValue = mapper.readValue(file, PojoRoot.class);
	PojoData pojoData = readValue.getData();
	System.out.println(pojoData.getId());
	System.out.println(pojoData.getFlightName());
	System.out.println(pojoData.getDestinations());
	System.out.println(pojoData.getuRL());
	System.out.println(pojoData.getCountry());
	System.out.println(pojoData.getCreated_Date());
	System.out.println(pojoData.getUpdated_Date());
	
	PojoSupport support = readValue.getSupport();
	}
	

}
