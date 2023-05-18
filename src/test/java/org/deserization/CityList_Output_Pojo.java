package org.deserization;

import java.util.ArrayList;

public class CityList_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<CityList_Output_Pojo_Data> data;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<CityList_Output_Pojo_Data> getData() {
		return data;
	}

	public void setData(ArrayList<CityList_Output_Pojo_Data> data) {
		this.data = data;
	}

}



