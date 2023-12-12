package com.springboot.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CommentDto {
	
	private long id;
	@NotEmpty
	@Size(min=2, message="Post title should have at least 2 charactetrs")
	private String name;
	
	@NotEmpty(message="name should not be null or empty")
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=10, message="Comment boday must be 10 char")
	private String body;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	

}
