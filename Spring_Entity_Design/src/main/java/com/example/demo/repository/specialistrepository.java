package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Branch;
import com.example.demo.entity.Specialist;

@Repository
public interface specialistrepository extends JpaRepository<Specialist, String>{
	
	

}
