package com.security.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloController {
	
 /*   @RequestMapping(value = "/login", method = RequestMethod.GET)  
    public String loginPage() {  
        return "login";  
    }*/ 
    
    
    @RequestMapping(value={"/welcome","/"},method=RequestMethod.POST)
    public String welcome(Model model){
    	System.out.println("Login success");
    	model.addAttribute("guestname", "guest");
        return "login-success";
    }
    
    
}
