package com.udemy.backendninja.service.impl;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.udemy.backendninja.service.EjercicioService;

@Service("ejercicioService")
public class EjercicioServiceImpl implements EjercicioService {

	private SecureRandom random = new SecureRandom();
	 
	@Override
	public String getMensaje() {
		// TODO Auto-generated method stub
		return new BigInteger(130, random).toString(32);
	
	}

}
