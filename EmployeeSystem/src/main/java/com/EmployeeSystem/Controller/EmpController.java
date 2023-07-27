package com.EmployeeSystem.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.EmployeeSystem.Entity.Employee;
import com.EmployeeSystem.Services.EmpServices;
import java.util.List;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
    private EmpServices empServices;
	
	@GetMapping("/emp")
	public String home(Model m)
	{
		List<Employee> emp=empServices.getAllEmp();
		
		m.addAttribute("emp",emp);
		return "index";
	}
	
	@GetMapping("/addEmp")
	public String addEmpForm()
	{
		return "addEmp";
	}
	
	@PostMapping("/register")
	public String registerEmp(@ModelAttribute Employee e, HttpSession session)
	{
		System.out.println(e);
		empServices.addEmp(e);
		session.setAttribute("msg", "Employee added Sucessfully.....");
		return "redirect:/";
	}
	
	@GetMapping("/updateEmp/{id}")
	public String editEmp(@PathVariable int id,Model m)
	{
		Employee e =empServices.getEmpById(id);
		m.addAttribute("emp",e);
		
		return "updateEmp";
	}
	
	@PostMapping("/update")
	public String UpdateEmp(@ModelAttribute Employee e, HttpSession session)
	{
		empServices.addEmp(e);
		session.setAttribute("msg", "Employee Data Update Sucessfully.....");
		return "redirect:/";
	}
	
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id , HttpSession session)
	{
		empServices.deleteEmp(id);
		session.setAttribute("msg", "Employee Data Deleted Sucessfully.....");
		return "redirect:/";
	}
}
