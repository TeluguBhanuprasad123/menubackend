package com.codelibary.www;

public class LoginResponse {
	
	private String message;
	private Object responseData;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResponseData() {
		return responseData;
	}
	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
	public LoginResponse(String message, Object responseData) {
		super();
		this.message = message;
		this.responseData = responseData;
	}
	public LoginResponse() {
		super();

	}
	
	
	

}
