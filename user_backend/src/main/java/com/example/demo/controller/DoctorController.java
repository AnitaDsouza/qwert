package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.Doctor;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DoctorRepository;

@RestController
@RequestMapping("/api")
public class DoctorController {
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public List<Doctor> getAllAdmins() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable(value = "id") Integer doctorId)
        throws ResourceNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
          .orElseThrow(() -> new ResourceNotFoundException("doctor not found for this id :: " + doctorId));
        return ResponseEntity.ok().body(doctor);
    }
    
    @PostMapping("/doctors")
    public Doctor createAdmin(@Valid @RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id") Integer doctorId,
         @Valid @RequestBody Doctor doctorDetails) throws ResourceNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
        .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorId));

        doctor.setFirstName(doctorDetails.getFirstName());
        doctor.setLastName(doctorDetails.getLastName());
        doctor.setGender(doctorDetails.getGender());
        doctor.setSpeciality(doctorDetails.getSpeciality());
        doctor.setBranch(doctorDetails.getBranch());
        final Doctor updatedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping("/doctors/{id}")
    public Map<String, Boolean> deleteDoctor(@PathVariable(value = "id") Integer doctorId)
         throws ResourceNotFoundException {
        Doctor doctor = doctorRepository.findById(doctorId)
       .orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + doctorId));

        doctorRepository.delete(doctor);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}