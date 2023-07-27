package com.iasys.jspView.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class jspViewController {

	@RequestMapping("/login")
	public String getLoginDetails()
	{
		  
		return "Login";
	}
}
