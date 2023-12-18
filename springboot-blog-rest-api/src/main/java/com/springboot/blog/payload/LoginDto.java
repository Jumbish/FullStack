package com.springboot.blog.payload;

public class LoginDto {
	private String password;
	private String userNameOrEmail;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserNameOrEmail() {
		return userNameOrEmail;
	}
	public void setUserNameOrEmail(String userNameOrEmail) {
		this.userNameOrEmail = userNameOrEmail;
	}
	public LoginDto(String password, String userNameOrEmail) {
		super();
		this.password = password;
		this.userNameOrEmail = userNameOrEmail;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
