package org.sample;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ListFlight {

	public static void main(String[] args) throws IOException, ParseException {
		// path of file
		FileReader fileReader = new FileReader(
				"C:\\Users\\Admin\\eclipse-workspace\\ApiSample\\src\\test\\resources\\ListFlight.json");

		// object for json file
		JSONParser parser = new JSONParser();

		// pass json file
		Object parse = parser.parse(fileReader);

		// class cast
		JSONObject jsonObject = (JSONObject) parse;
		System.out.println(jsonObject);

		Object objPage = jsonObject.get("page");
		System.out.println(objPage);

		Object objPerpage = jsonObject.get("per_page");
		System.out.println(objPerpage);

		Object objTotel = jsonObject.get("total");
		System.out.println(objTotel);

		Object objTotelpage = jsonObject.get("total_pages");
		System.out.println(objTotelpage);

		Object objData = jsonObject.get("data");
		// System.out.println(objData);

		JSONArray array = (JSONArray) objData;
		for (int i = 0; i < array.size(); i++) {

			Object object2 = array.get(i);
			JSONObject jsonObject2 = (JSONObject) object2;

			Object objid = jsonObject2.get("id");
			System.out.println(objid);

			Object objfName = jsonObject2.get("flightName");
			System.out.println(objfName);

			Object objCountry = jsonObject2.get("Country");
			System.out.println(objCountry);

			Object objDestination = jsonObject2.get("Destination");
			System.out.println(objDestination);

			Object objURL = jsonObject2.get("URL");
			System.out.println(objURL);
			
		}

			Object objSupport = jsonObject.get("support");
			JSONObject jsonObject2 = (JSONObject) objSupport;
			System.out.println(objSupport);

			Object objurl1 = jsonObject2.get("url");
			System.out.println(objurl1);

			Object objtext = jsonObject2.get("text");
			System.out.println(objtext);

		}

	}


