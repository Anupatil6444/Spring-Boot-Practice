package com.sts.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	@RequestMapping("/home")
	public String home()
	{
		System.out.println("This is our home page");
		return "home";
	}
	@RequestMapping("/contact")
	public String contact()
	{
		System.out.println("This is our contact page");
		return "contact";
	}
}