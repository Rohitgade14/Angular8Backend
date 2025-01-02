package com.krios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krios.entity.UserData;
import com.krios.service.DataService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class DataController {
	
	@Autowired
	private DataService dataService;
	
	@PostMapping
	public ResponseEntity<UserData> createData(@RequestBody UserData userData) {
		   System.out.println("Received data: " + userData);
		     UserData savedUser = dataService.createUser(userData);
		     return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	@GetMapping
	public ResponseEntity<List<UserData>> getdata(){
		 List<UserData> allUsers = dataService.getAllUsers();
		 return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	@GetMapping("/page")
	public ResponseEntity<List<UserData>> getAllUsersByPage(
			@RequestParam(defaultValue = "0",required = false) Integer pageNumber,
			@RequestParam(value="pagesize",defaultValue = "5",required = false)Integer pageSize)
			{
		 List<UserData> allUsers = dataService.getAllUsersByPage(pageNumber, pageSize);
		 return ResponseEntity.status(HttpStatus.OK).body(allUsers);
	}
	

}
