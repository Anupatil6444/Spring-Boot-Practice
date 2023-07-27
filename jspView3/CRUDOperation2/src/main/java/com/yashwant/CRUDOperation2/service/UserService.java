package com.yashwant.CRUDOperation2.service;

import java.util.List;

import com.yashwant.CRUDOperation2.entity.Users;

public interface UserService {
	public List<Users> getAllUsers();
	public Users getUserById(int userId);
	public Users addOrUpdateUser(Users user);
	public Users deleteUser(int userId) throws Exception;
	
	

}
