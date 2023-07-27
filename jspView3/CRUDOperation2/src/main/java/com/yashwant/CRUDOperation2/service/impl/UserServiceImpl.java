package com.yashwant.CRUDOperation2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yashwant.CRUDOperation2.entity.Users;
import com.yashwant.CRUDOperation2.repository.UserRepository;
import com.yashwant.CRUDOperation2.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Users> getAllUsers() {
		
		return (List<Users>)userRepository.findAll();
			
	}

	@Override
	public Users getUserById(int userId) {
		
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public Users addOrUpdateUser(Users user) {
		
		return userRepository.save(user);
	}

	@Override
	public Users deleteUser(int userId) throws Exception {
		Users deleteUser=null;
		try {
			deleteUser=userRepository.findById(userId).orElse(null);
			if(deleteUser==null)
			{
				throw new Exception("User is not Available");
			}
			else
				userRepository.deleteById(userId);
		}
		catch(Exception e)
		{
			throw e;
		}
		return deleteUser;
	}

}
