package com.iasys.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login";
	}
}
