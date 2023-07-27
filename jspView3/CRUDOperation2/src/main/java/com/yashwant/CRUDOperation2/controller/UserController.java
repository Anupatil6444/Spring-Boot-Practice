package com.yashwant.CRUDOperation2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yashwant.CRUDOperation2.entity.Users;
import com.yashwant.CRUDOperation2.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController{
	@Autowired
	
	private UserService userService;

	@GetMapping("/allUsers")
	public ResponseEntity <List<Users>> getAllUsers()
	{
		List<Users>user=null;
		try {
			user=userService.getAllUsers();
			
			
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return new ResponseEntity <List<Users>>(user,HttpStatus.OK);
	}
	
	@GetMapping("/getUserById/{id}")
	public ResponseEntity <Users> getUserById(@PathVariable("id") int userId)
	{
		
		Users user=null;
		try {
			user=userService.getUserById(userId);
			
			
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return new ResponseEntity <Users>(user,HttpStatus.OK);
	}
	
	@PostMapping("/addOrUpdate")
	public ResponseEntity <Users> addOrUpdate(@RequestBody Users user)
	{
	
		
		try {
			user=userService.addOrUpdateUser(user);
			
			
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return new ResponseEntity <Users>(user,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Users> delete(@PathVariable("id") int userId)
	{
		Users user=null;
		
		try {
			user=userService.deleteUser(userId);
			
			
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return new ResponseEntity <Users>(user,HttpStatus.OK);
	}
	
}
