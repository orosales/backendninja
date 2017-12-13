package com.udemy.backendninja.converter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Testcript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));

	}

}
