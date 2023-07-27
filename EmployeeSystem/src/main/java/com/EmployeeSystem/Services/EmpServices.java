
package com.EmployeeSystem.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeSystem.Entity.Employee;
import com.EmployeeSystem.Repository.EmpRepository;
@Service
public class EmpServices {
	@Autowired
	private EmpRepository empRepository;
	
	public void addEmp(Employee e)
	{
		empRepository.save(e);
	}
	
	public List<Employee> getAllEmp()
	{
		return empRepository.findAll();	
	}
	
	public Employee getEmpById(int id)
	{
		Optional<Employee> e=empRepository.findById(id) ;
		if(e.isPresent())
		{
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id)
	{
		empRepository.deleteById(id);
	}
}
