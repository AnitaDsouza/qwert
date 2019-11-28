package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Branch;
import com.example.demo.entity.DoctorRegistration;
import com.example.demo.entity.Specialist;
import com.example.demo.repository.PatientRegistrationRepository;
import com.example.demo.repository.branchrepository;
import com.example.demo.repository.specialistrepository;

@RestController
@RequestMapping("/api")
public class branchandspecialistcontroller {

	@Autowired
	branchrepository barepository;
	
	@Autowired
	specialistrepository spclrepository;
	
	
	
	 @GetMapping("/branch")
	    public List<Branch> findAll(){
	        return barepository.findAll();	
	        }
	 

	 @GetMapping("/specialist")
	    public List<Specialist> findspcl(){
	        return spclrepository.findAll();	
	        }
}
