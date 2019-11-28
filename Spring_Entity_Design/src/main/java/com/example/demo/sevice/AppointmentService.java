package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Appointment;

public interface AppointmentService {
	
	public List<Appointment> getAppointments();

	public Appointment  saveAppointment(Appointment theAppointment);

	public   Optional<Appointment> getAppointmentById(int theId);

	public void deleteAppointmentById(int theId);

	public Appointment updatepatientregistration(Appointment appointment);

}
