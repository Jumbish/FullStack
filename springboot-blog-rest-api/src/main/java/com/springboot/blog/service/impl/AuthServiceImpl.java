package com.springboot.blog.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Role;
import com.springboot.blog.entity.User;
import com.springboot.blog.exception.BlogApiException;
import com.springboot.blog.payload.LoginDto;
import com.springboot.blog.payload.RegisterDto;
import com.springboot.blog.repository.RoleRepository;
import com.springboot.blog.repository.UserRepository;
import com.springboot.blog.security.JwtTokenProvider;
import com.springboot.blog.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	private AuthenticationManager authenticationManager;

	private UserRepository userRepository;

	private RoleRepository roleRepository;

	private PasswordEncoder passwordEncoder;

	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
			RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtTokenProvider = jwtTokenProvider;
	}
//for basic login rest api
//	@Override
//	public String login(LoginDto loginDto) {
//		// TODO Auto-generated method stub
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginDto.getUserNameOrEmail(), loginDto.getPassword()));
//
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//
//		return "User login successfully";
//	}
	
	
	@Override
	public String login(LoginDto loginDto) {
		// TODO Auto-generated method stub
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUserNameOrEmail(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String token = jwtTokenProvider.generateToken(authentication);
		return token;
	}

	@Override
	public String register(RegisterDto registerDto) {
		if (userRepository.existsByUserName(registerDto.getUserName())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "UserName is already exist");
		}

		if (userRepository.existsByEmail(registerDto.getEmail())) {
			throw new BlogApiException(HttpStatus.BAD_REQUEST, "Email is already exist");
		}

		User user = new User();

		user.setName(registerDto.getName());
		user.setUserName(registerDto.getUserName());
		user.setEmail(registerDto.getEmail());
		user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

		Set<Role> roles = new HashSet<>();

		Role userRole = roleRepository.findByName("ROLE_USER").get();
		roles.add(userRole);

		user.setRoles(roles);

		userRepository.save(user);

		return "user repo save successfully";
	}

}
