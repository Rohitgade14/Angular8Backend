package com.krios.serviceimpl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.krios.entity.UserData;
import com.krios.repository.DataRepository;
import com.krios.service.DataService;

@Service
public class DataServiceImpl  implements DataService{

   @Autowired
   DataRepository dataRepository;
   private static final Logger logger =LoggerFactory.getLogger(DataServiceImpl.class);
   
	public UserData createUser(UserData userData) {
		logger.info("Creating user with title: {}",userData.getTitle());
		UserData savedUser = new UserData();
		savedUser.setId(userData.getId());
		savedUser.setTitle(userData.getTitle());
		savedUser.setContent(userData.getContent());
		savedUser.setFristName(userData.getFristName());
		savedUser.setLastName(userData.getLastName());
		logger.info("User Created sucesfully with ID: {}" ,savedUser.getId());
		return dataRepository.save(savedUser);
	}
	
	public List<UserData> getAllUsers() {
		logger.info("Fetching all users");
		 List<UserData> allUsers = dataRepository.findAll();
		 logger.info("Total users fetched: {}", allUsers.size());
		   return allUsers;
	}

	@Override
	public List<UserData> getAllUsersByPage(Integer pageNumber, Integer pageSize) {
		logger.info("Fetching all users with pagination");
		
		// pageable object get through the pageRequest
		
		 // Use default values if inputs are null or invalid
//	    int page = (pageNumber != null && pageNumber > 0) ? pageNumber : 1;
//	    int size = (pageSize != null && pageSize > 0) ? pageSize : 5;
//		  Pageable pageable = PageRequest.of(page - 1, size);
		
		Pageable pageable = PageRequest.of(pageNumber,pageSize);
		 Page<UserData> userPage = dataRepository.findAll(pageable);
		 logger.info("Total users fetched: {}", userPage.getNumberOfElements());
          return userPage.getContent();
	}
	 
	


	

}
