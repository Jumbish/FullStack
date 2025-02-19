package com.springboot.blog.utils;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("java");
		String s1 = sb.toString();
		String s2 = sb.toString();
		
		System.out.println(s1==s2);
	}
}
