package com.security.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage(@RequestParam(value = "error", required = false) String error, 
    			Model model, HttpServletRequest request) {
    	System.out.println("error:" + error);
        if (error != null) {
        	//获取全部异常信息 start
        	HttpSession session  = request.getSession();
        	Exception exception = (Exception) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        	System.out.println(exception.getMessage());//异常原因摘要描述
        	StringWriter sw = new StringWriter();
        	exception.printStackTrace(new PrintWriter(sw)); //获取全部异常信息
        	System.out.println(sw.toString());
        	//end
            return "login-failure";
        }
        return "login";
    }
}