package com.udemy.backendninja.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.backendninja.constant.ViewConstant;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	/*@GetMapping("/")
	public String redirectToLogin() {
		
		LOG.info("Method: redirectToLogin() ");
		return "redirect:/login";
	}*/
	
	@GetMapping("/login") 
	public String showLoginForm(Model model, 
			@RequestParam(name="error",  required=false ) String error,
			@RequestParam(name="logout",  required=false ) String logout) {
		
		LOG.info("Method: showLoginForm() -- PARAMS: error=" + error + "logout="+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		//model.addAttribute("userCredentials", new UserCredential());
		LOG.info("returning to login view");
		return ViewConstant.LOGIN;
	}
	
	/*@PostMapping("/logincheck") 
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredential userCredential ) {
		
		LOG.info("Method: loginCheck() -- PARAMS: " + userCredential.toString() );
		
		if ( userCredential.getUsername().equals("user") &&
				userCredential.getPassword().equals("user")) {
			LOG.info("returning to contact view");
			//return ViewConstant.CONTACTS;	
			return "redirect:/contacts/showcontacts";
		} else {
			LOG.info("redirect to login?error ");
			return "redirect:/login?error";
		}
		
		
	}*/
	
	@GetMapping( {"/loginsuccess", "/"}) 
	public String loginCheck( ) {
		
		LOG.info("Method: loginCheck() " );
		
		return "redirect:/contacts/showcontacts";
		
	}
	
}
