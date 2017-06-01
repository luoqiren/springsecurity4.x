package com.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "/defaultPage", method = RequestMethod.GET)
	public String defaultPage() {
		System.out.println("defaultPage");
		return "login";
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.POST)
	public String loginPage(@RequestParam(value = "error", required = false) String error, Model model) {
		System.out.println("error:" + error);
		System.out.println("loginPage");
		if (error != null) {
			return "login-failure";
		}
		return "login";
	}
}