package com.example.Spring_Boot_CC1_Login.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring_Boot_CC1_Login.Model.Model;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model, Integer> {

	Optional<Model> findByEmail(String email);

}
