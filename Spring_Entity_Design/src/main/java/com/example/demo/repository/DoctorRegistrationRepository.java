package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DoctorRegistration;



@Repository
public interface DoctorRegistrationRepository extends JpaRepository<DoctorRegistration, Integer>{
	 List<DoctorRegistration> findByBranchContainsAndSpecialistContainsAllIgnoreCase(String branch, String specialist);
}
