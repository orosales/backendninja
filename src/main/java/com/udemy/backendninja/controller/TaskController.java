package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.udemy.backendninja.service.EjercicioService;
import com.udemy.backendninja.service.ExampleService;

@Controller
@RequestMapping("/ejercicio")
public class TaskController {
	
	public static final String METODO1_VIEW = "method1";
	public static final String METODO2_VIEW = "method2";
	
	private static final Log LOG = LogFactory.getLog(TaskController.class);
	
	@Autowired
	@Qualifier("ejercicioService")
	private EjercicioService ejercicioService;
	
	@GetMapping("/method1")
	public RedirectView method1() {
		
		LOG.info("EN EL METODO method1");
		//return METODO1_VIEW;
		return new RedirectView("/ejercicio/method2");
	}
	
	@GetMapping("/method2")
	public ModelAndView method2() {
		
		ModelAndView mav = new ModelAndView(METODO2_VIEW);
		LOG.info("EN EL METODO method2");
		mav.addObject("mensaje", ejercicioService.getMensaje() );
		
		return mav;
	}

}

