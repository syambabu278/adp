package com.adp.web.vo;

public class ResponseData {

	String status;
	String message;
	int statusCode;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ResponseData [status=" + status + ", message=" + message
				+ ", statusCode=" + statusCode + "]";
	}
	
	

}
