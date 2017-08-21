package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService{

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add( new Person("John", 23) );
		people.add( new Person("Mikel", 30) );
		people.add( new Person("Eva", 40) );
		people.add( new Person("Peter", 32) );
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

	
}
