package org.deserization;

import java.util.ArrayList;

public class GetUserAddress_Output_Pojo {
	private int status;
	private String message;
	private ArrayList<GetUserAddress_Output_Data_Pojo> data;
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
	public ArrayList<GetUserAddress_Output_Data_Pojo> getData() {
		return data;
	}
	public void setData(ArrayList<GetUserAddress_Output_Data_Pojo> data) {
		this.data = data;
	}

}
