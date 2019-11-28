package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DoctorRegistration;
import com.example.demo.sevice.DoctorRegistrationService;

@RestController
@RequestMapping("/api")
public class DoctorRegistrationController {

    @Autowired
    private DoctorRegistrationService doctorRegistrationService;

    @PostMapping("/doctorregister")
    public DoctorRegistration create(@RequestBody DoctorRegistration doctor){
        return doctorRegistrationService.saveDoctorRegistration(doctor);
    }

    @GetMapping(path = {"/doctorregister/{id}"})
    public Optional<DoctorRegistration> findOne(@PathVariable("id") int id){
        return doctorRegistrationService.getDoctorRegistrationById(id);
    }
    
    @PostMapping(path = {"/doctorschedule"})
    public List<DoctorRegistration> getschedule(@RequestBody DoctorRegistration doctor){
    	return doctorRegistrationService.getDoctorSchedule(doctor.getBranch(), doctor.getSpecialist());
    }

    @PutMapping("/doctorregister")
    public DoctorRegistration update(@RequestBody DoctorRegistration doctor){
        return doctorRegistrationService.updateDoctorRegistration(doctor);
    }

    @DeleteMapping(path ={"/doctorregister/{id}"})
    public void delete(@PathVariable("id") int id) {
         doctorRegistrationService.deleteDoctorRegistrationById(id);
    }

    @GetMapping("/doctorregister")
    public List<DoctorRegistration> findAll(){
        return doctorRegistrationService.getDoctorRegistrations();
    }
}