package org.deserization;

import java.util.ArrayList;

public class GetStateList_Output_Pojo {
	 public int status;
	    public String message;
	    public ArrayList<GetStateList_Output_Data_Pojo> data;
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
		public ArrayList<GetStateList_Output_Data_Pojo> getData() {
			return data;
		}
		public void setData(ArrayList<GetStateList_Output_Data_Pojo> data) {
			this.data = data;
		}
}
		
