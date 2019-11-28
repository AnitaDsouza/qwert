package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.DoctorRegistration;

public interface DoctorRegistrationService {
	
	public List<DoctorRegistration> getDoctorRegistrations();

	public DoctorRegistration saveDoctorRegistration(DoctorRegistration theDoctorRegistration);

	public  Optional<DoctorRegistration> getDoctorRegistrationById(int theId);

	public void deleteDoctorRegistrationById(int theId);
	public DoctorRegistration updateDoctorRegistration(DoctorRegistration patient) ;
	public List<DoctorRegistration> getDoctorSchedule(String branch, String specialist);

}
