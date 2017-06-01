package com.security.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloController {
	
 /*   @RequestMapping(value = "/login", method = RequestMethod.GET)  
    public String loginPage() {  
        return "login";  
    }*/ 
    
    
    @RequestMapping(value={"/welcome","/"},method=RequestMethod.GET)
    public String welcome(){
    	System.out.println("Login success");
        return "login-success";
    }
    
    
}
