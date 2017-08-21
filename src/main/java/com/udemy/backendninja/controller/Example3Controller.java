package com.udemy.backendninja.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {

	private static final Log LOGGER = LogFactory.getLog(Example3Controller.class);
	public static final String FORM_VIEW ="form";
	public static final String RESULT_VIEW ="result";

	/*
	@GetMapping("/")
	public String redirect() {
		return "redirect:/example3/showForm";
	}*/
	
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example3/showForm");
	}
	
	@GetMapping("/showForm")
	public String showform(Model model) {
		/*LOGGER.info("INFO TRACE");
		LOGGER.warn("WARNING TRACE");
		LOGGER.error("ERROR TRACE");
		LOGGER.debug("DEBUG TRACE"); */
		
		model.addAttribute("person", new Person());
		//int i = 6/0;
		return FORM_VIEW;
	}
	
	@PostMapping("/addPerson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		
		//LOGGER.info("METHOD 'addPerson' -- params:'" + person +"'");
		ModelAndView mav= new ModelAndView();
		if (bindingResult.hasErrors()) {
			
			mav.setViewName(FORM_VIEW);
		} else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
			//LOGGER.info("TEMPLATE :'"+RESULT_VIEW+"' --DATA: '"+person +"' ");
		}
		
		
		
		return mav;
	}
	
}
