package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.PatientRegistration;

@Repository
public interface PatientRegistrationRepository extends JpaRepository<PatientRegistration, Integer>{

	public PatientRegistration findByEmail(
			String theEmail);

}