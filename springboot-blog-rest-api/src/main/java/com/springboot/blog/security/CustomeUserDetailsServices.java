package com.springboot.blog.security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.User;
import com.springboot.blog.repository.UserRepository;

@Service
public class CustomeUserDetailsServices implements UserDetailsService {

	private UserRepository userRepository;

//	@Autowired can be ommitted as this constructor is single parameterized constructor, spring will automatically inject the dependency
	public CustomeUserDetailsServices(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

//		getting this details from the db
		User user = userRepository.findByuserNameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() -> new UsernameNotFoundException("user not found with user or email"));
//		lets lets convert this user to spring provided UserObject
//		 this code processes the roles associated with a user and converts them into a set of GrantedAuthority objects. Each role is mapped to a SimpleGrantedAuthority object, and the resulting authorities are collected into a Set<GrantedAuthority>. The GrantedAuthority interface is often used in Spring Security to represent the authorities/roles granted to a user, and SimpleGrantedAuthority is a simple implementation of that interface. This set of authorities can then be used for authentication and authorization purposes in a Spring Security context.
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

}
