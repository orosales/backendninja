package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/example4")
public class Example4Controller {

	@GetMapping("/paginaError")
	public String getVista() {
		return "404";
	}
	
	@GetMapping("/paginaError2")
	public String getVista2() {
		return "500";
	}
}
