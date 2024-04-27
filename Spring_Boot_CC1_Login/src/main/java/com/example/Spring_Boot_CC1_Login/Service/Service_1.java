package com.example.Spring_Boot_CC1_Login.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Spring_Boot_CC1_Login.Model.Model;
import com.example.Spring_Boot_CC1_Login.Repository.Repository;

@Service
public class Service_1 {
	@Autowired
	private Repository repository;

	public Model createNewUser(@NonNull Model user) {
		return repository.save(user);
	}

	public List<Model> getAllUserDetais() {
		return repository.findAll();
	}

	public Model updateUserDetails(@NonNull String email, @RequestBody Model User) {
		return repository.findByEmail(email).map(existingUser -> {
			existingUser.setEmail(User.getEmail());
			existingUser.setPassword(User.getPassword());
			return repository.save(existingUser);
		}).orElseThrow(() -> new RuntimeException("User not found with this username " + email));
	}
	
	public void RemoveUser(@NonNull Integer id) {
		repository.deleteById(id);
	}

}
