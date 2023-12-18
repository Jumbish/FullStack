package com.springboot.blog.service;

import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.RegisterDto;
// for login rest Api
public interface AuthService {
	
	String login(LoginDto loginDto);
	
	String register(RegisterDto registerDto);

}
