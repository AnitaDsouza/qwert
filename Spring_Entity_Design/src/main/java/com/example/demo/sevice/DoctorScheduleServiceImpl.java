package com.example.demo.sevice;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DoctorSchedule;
import com.example.demo.repository.DoctorScheduleRepository;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {
	
	@Autowired
	DoctorScheduleRepository doctorSchedulerepository;

	@Override
	@Transactional
	public List<DoctorSchedule> getDoctorSchedules() {
		// TODO Auto-generated method stub
		return doctorSchedulerepository.findAll();
	}

	@Override
	@Transactional
	public void saveDoctorSchedule(DoctorSchedule theDoctorSchedule) {
		// TODO Auto-generated method stub
		doctorSchedulerepository.save(theDoctorSchedule);
		
	}

	@Override
	@Transactional
	public Optional<DoctorSchedule> getDoctorScheduleById(int theId) {
		// TODO Auto-generated method stub
		
		return doctorSchedulerepository.findById(theId);
	}

	@Override
	@Transactional
	public void deleteDoctorScheduleById(int theId) {
		// TODO Auto-generated method stub
		doctorSchedulerepository.deleteById(theId);
		
	}

}
