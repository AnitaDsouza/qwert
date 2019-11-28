package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DoctorRegistration;
import com.example.demo.repository.DoctorRegistrationRepository;

@Service
public class DoctorRegistrationServiceImpl implements DoctorRegistrationService {
	
	@Autowired
	DoctorRegistrationRepository doctorRegistrationrepository;

	@Override
	@Transactional
	public List<DoctorRegistration> getDoctorRegistrations() {
		// TODO Auto-generated method stub
		return doctorRegistrationrepository.findAll();
	}

	@Override
	@Transactional
	public DoctorRegistration saveDoctorRegistration(DoctorRegistration theDoctorRegistration) {
		// TODO Auto-generated method stub
		return doctorRegistrationrepository.save(theDoctorRegistration);
		
	}

	@Override
	@Transactional
	public Optional<DoctorRegistration> getDoctorRegistrationById(int theId) {
		// TODO Auto-generated method stub
		
		return doctorRegistrationrepository.findById(theId);
	}

	@Override
	@Transactional
	public void deleteDoctorRegistrationById(int theId) {
		// TODO Auto-generated method stub
		Optional<DoctorRegistration> patient = getDoctorRegistrationById(theId);
        if(patient != null){
        	doctorRegistrationrepository.deleteById(theId);
        }
        
		
	}

	@Override
	public DoctorRegistration updateDoctorRegistration(DoctorRegistration patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorRegistration> getDoctorSchedule(String branch, String specialist) {
		// TODO Auto-generated method stub
		return doctorRegistrationrepository.findByBranchContainsAndSpecialistContainsAllIgnoreCase(branch, specialist);
	}

}