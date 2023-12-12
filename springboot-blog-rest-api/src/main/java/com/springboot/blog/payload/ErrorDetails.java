package com.springboot.blog.payload;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorDetails {
	
	private Date timeStamp;
	private String message;
	private String details;
	private HttpStatus statusCodel;
	public ErrorDetails(Date timeStamp, String message, String details, HttpStatus statusCodel) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
		this.statusCodel = statusCodel;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}
	public HttpStatus getStatusCodel() {
		return statusCodel;
	}
	
	
	
	
	
	

}
