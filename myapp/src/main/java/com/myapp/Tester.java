package com.myapp;

import com.myapp.dto.Employee;
import com.myapp.validator.Validator;

public class Tester {
	public static void main(String[] args) throws Exception{		
		try {
			Employee employee = new Employee(1234,"",120000);
			new Validator().validate(employee);
			System.out.println("The employee details are successfully validated.");
		} 
		catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}
}