package com.example.Spring_Boot_CC1_Login.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_Boot_CC1_Login.Model.Model;
import com.example.Spring_Boot_CC1_Login.Service.Service_1;

@RestController
@RequestMapping("/login_data")
public class Controller {
	@Autowired
	Service_1 services;
	@PostMapping("/createUser")
	public ResponseEntity<Model> createNewUser(@NonNull @RequestBody Model user){
		Model created_user=services.createNewUser(user);
		return new ResponseEntity<>(created_user,HttpStatus.CREATED);
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<Model>> getAllUserDetails(){
		List<Model> allDetails=services.getAllUserDetais();
		return new ResponseEntity<>(allDetails, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{email}")
	public ResponseEntity<Model> updateUser(@NonNull @PathVariable String email,@RequestBody Model user){
		Model updatedDetailsModel=services.updateUserDetails(email, user);
		return new ResponseEntity<>(updatedDetailsModel,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@NonNull @PathVariable Integer id) {
		services.RemoveUser(id);
	}
}