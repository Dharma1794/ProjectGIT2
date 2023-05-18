package org.deserization;

import org.apache.groovy.parser.antlr4.GroovyParser.AdditiveExprAltContext;
import org.baseclass.BaseClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AuthLoginAddadress extends BaseClass {
	String logtoken;
	String address_id;
	String state_id;
	int stateIdNum;
	int cityIdNum;
	

	@Test(priority = 3)

	private void getCityList() {

		// 1.Headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2.pay load

		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(state_id);
		addBody(cityList_Input_Pojo);

		// 3.reqtype

		Response response = addReqType("POST", "https://www.omrbranch.com/api/cityList\r\n");

		int actStatusCode = getStatusCode(response);
		System.out.println("The Actual Status Code for getCityList-->" + actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify Status Code");

		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);

		// to get the city list
		ArrayList<CityList_Output_Pojo_Data> cityList = cityList_Output_Pojo.getData();

		for (CityList_Output_Pojo_Data eachCityList : cityList) {

			String cityName = eachCityList.getName();
			// to get city Id for Tenkasi-->this id is used to pass in addUserAddress
			if (cityName.equals("Tenkasi")) {
				cityIdNum = eachCityList.getId();
				System.out.println("City Id of Tenkasi-->" + cityIdNum);
				break;
			}
		}
		// to get the actual message
		String actMessage = cityList_Output_Pojo.getMessage();
		System.out.println("The Actual Message for getCityList-->" + actMessage);
		Assert.assertEquals(actMessage, "OK", "Verify OK");

	}
	
	@Test(priority = 2)
	public void getStateList() {

		// 1.Headers
		addHeader("accept", "application/json");

		// 2.reqType

		Response response = addReqType("GET", "https://www.omrbranch.com/api/stateList");
		int actStatusCode = getStatusCode(response);
		System.out.println("The Actual Status Code for getStateList-->" + actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify Status Code");
		GetStateList_Output_Pojo stateList_Output_Pojo = response.as(GetStateList_Output_Pojo.class);

		// to get the state list
		ArrayList<GetStateList_Output_Data_Pojo> stateList = stateList_Output_Pojo.getData();

		for (GetStateList_Output_Data_Pojo eachStateList : stateList) {
			String stateName = eachStateList.getName();

			// to get State Id for Tamil Nadu-->this id is used to pass in addUserAddress
			if (stateName.equals("Tamil Nadu")) {
				stateIdNum = eachStateList.getId();
				state_id = String.valueOf(stateIdNum);
				System.out.println("The State id of Tamil Nadu-->" + stateIdNum);
				break;
			}

		}
		// to get the actual message
		String actMessage = stateList_Output_Pojo.getMessage();
		System.out.println("The Actual message for getStateList-->" + actMessage);
		Assert.assertEquals(actMessage, "OK", "Verify OK");

	}

		
	
	
	@Test(priority = 8)
	public void searchProduct() {

		// 1.Headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
	

		// 2.payload
	
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo("nuts");
		addBody(searchProduct_Input_Pojo);

	// 3.reqtype

	Response response = addReqType("POST", "https://www.omrbranch.com/api/searchProduct");
	int actStatusCode = getStatusCode(response);
	System.out.println("The Actual Status Code for searchProduct-->" + actStatusCode);
	Assert.assertEquals(actStatusCode, 200, "Verify Status Code");

	SearchProduct_Output_Pojo searchProduct_Ouput_Pojo = response.as(SearchProduct_Output_Pojo.class);
	// to get the actual message
	String actMessage = searchProduct_Ouput_Pojo.getMessage();
	System.out.println("The Actual Message for searchProduct-->" + actMessage);
	Assert.assertEquals(actMessage, "OK", "Verify Search Product");
}
	@Test(priority = 7)
	public void deleteUserAddress() {
		// 1.Headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", " Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2.payload

		DeleteAddress_Input_Pojo deleteUserAddress_Input_Pojo = new DeleteAddress_Input_Pojo(address_id);
		addBody(deleteUserAddress_Input_Pojo);

		// 3.reqtype

		Response response = addReqType("DELETE", "https://www.omrbranch.com/api/deleteAddress");

		int actStatusCode = getStatusCode(response);
		System.out.println("The Actual Status Code for deleteUserAddress-->" + actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify Status Code");

		DeleteAddress_Output_Pojo deleteUserAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);

		// to get the actual message
		String actMessage = deleteUserAddress_Output_Pojo.getMessage();
		System.out.println("The Actual Message for deleteUserAddress-->" + actMessage);
		Assert.assertEquals(actMessage, "Address deleted successfully", "Verify Address deleted successfully");

	}
	
	@Test(priority = 6)
	public void getUserAddress() {
		// 1Headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", " Bearer " + logtoken);
		
		listHeader.add(h1);
		listHeader.add(h2);
		
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
				// req type
				Response response = addReqType("GET", "https://omrbranch.com/api/getUserAddress");
				int actStatusCode = getStatusCode(response);
				System.out.println(actStatusCode);
				Assert.assertEquals(actStatusCode, 200, "Verify status code");

				GetUserAddress_Output_Pojo getUserAddress_Output_Pojo = response.as(GetUserAddress_Output_Pojo.class);
				String actMessage = getUserAddress_Output_Pojo.getMessage();
				Assert.assertEquals(actMessage, "OK", "Verify get Address");

	}
	
	@Test(priority = 5)
	public void updateUserAddress() {
		// 1.Headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", " Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
		
		// 2.payload
		UpdateUserAddress_Input_pojo updateUserAddress_Input_pojo= new UpdateUserAddress_Input_pojo(address_id,"Dharma", "Raj",
				"9042209787", "HappyStay", 627708, 765, 100, "600108", "Thoraippakkam", "Work");
		addBody(updateUserAddress_Input_pojo);
				
				// 3.req type
				Response response = addReqType("PUT", "https://omrbranch.com/api/updateUserAddress");
				int actStatusCode = getStatusCode(response);
				System.out.println(actStatusCode);

				Assert.assertEquals(actStatusCode, 200, "Verify status code");

				
				UpdateUserAddress_Output_Pojo as = response.as(UpdateUserAddress_Output_Pojo.class);
				String message = as.getMessage();
				Assert.assertEquals(message, "Address updated successfully", "Verify Update Successfully");
				
	}	

	@Test(priority = 1)
	 private void stateList() {
		addHeader("accept", "application/json");
		addBasicAuth("dharmablue7@gmail.com", "Dharma1234@5");
		Response response2 = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");
		int statusCode = response2.statusCode();
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "verify statuscode");
		Root as = response2.as(Root.class);
		String first_name = as.getData().getFirst_name();
		System.out.println(first_name);
		logtoken = as.getData().getLogtoken();
		Assert.assertEquals(first_name, "Dharma", "verify firstname");
	}

	@Test(priority = 4)

	public void addUserAddress() {

		// 1.Headers
		List<Header> listHeader = new ArrayList<>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", " Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2.payload
		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("Dharma", "Raj",
				"9042209787", "HappyStay", 627708, 765, 100, "600108", "Thoraippakkam", "Work");

		addBody(addUserAddress_Input_Pojo);

		// 3.req type
		Response response = addReqType("POST", "https://www.omrbranch.com/api/addUserAddress");
		int actStatusCode = getStatusCode(response);
		System.out.println(actStatusCode);
		Assert.assertEquals(actStatusCode, 200, "Verify status code");
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String actMessage = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(actMessage, "Address added successfully", "Verify Address added successfully");
		int address_id1 = addUserAddress_Output_Pojo.getAddress_id();
		address_id=String.valueOf(address_id1);
	}
}
