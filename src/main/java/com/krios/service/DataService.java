package com.krios.service;

import java.util.List;

import com.krios.entity.UserData;

public interface DataService {
	
	public UserData createUser(UserData userData);
	
	public List<UserData> getAllUsers();
	
   public	List<UserData> getAllUsersByPage(Integer pageNumber ,Integer pageSize);

}
