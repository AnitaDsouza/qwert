package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Appointment;
import com.example.demo.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	AppointmentRepository Appointmentrepository;

	@Override
	@Transactional
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return Appointmentrepository.findAll();
	}

	@Override
	@Transactional
	public Appointment saveAppointment(Appointment theAppointment) {
		// TODO Auto-generated method stub
		return Appointmentrepository.save(theAppointment);
		
	}

	@Override
	@Transactional
	public Optional<Appointment> getAppointmentById(int theId) {
		// TODO Auto-generated method stub
		
		return Appointmentrepository.findById(theId);
	}

	@Override
	@Transactional
	public void deleteAppointmentById(int theId) {
		// TODO Auto-generated method stub
		Optional<Appointment> appointment =  getAppointmentById(theId);
        if(appointment  != null){
        	Appointmentrepository.deleteById(theId);
        }
		
		
	}

	@Override
	public Appointment updatepatientregistration(Appointment appointment) {
		// TODO Auto-generated method stub
		return null;
	}

}