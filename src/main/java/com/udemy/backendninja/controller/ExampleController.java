package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW= "example";

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//primera forma - Para redirecciones
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		//model.addAttribute("name", "John");
		//model.addAttribute("person", new Person("John", 23));
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}
	
	//segunda forma - cuando hay que insertar datos
	//@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	@GetMapping("/exampleMAV")
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("people",  exampleService.getListPeople() );
		
		return mav;
	}
	

}
