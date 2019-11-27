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

import com.example.demo.entity.PatientRegistration;
import com.example.demo.sevice.PatientRegistrationService;

@RestController
@RequestMapping("/api")
public class PatientRegistrationController {

    @Autowired
    private PatientRegistrationService patientRegistrationService;

    @PostMapping("/patientregister")
    public PatientRegistration create(@RequestBody PatientRegistration patient){
        return patientRegistrationService.savePatientRegistration(patient);
    }

    @GetMapping(path = {"/patientregister/{id}"})
    public Optional<PatientRegistration> findOne(@PathVariable("id") int id){
        return patientRegistrationService.getPatientRegistrationById(id);
    }

    @PutMapping("/patientregister")
    public PatientRegistration update(@RequestBody PatientRegistration user){
        return patientRegistrationService.updatepatientregistration(user);
    }

    @DeleteMapping(path ={"/patientregister/{id}"})
    public void delete(@PathVariable("id") int id) {
         patientRegistrationService.deletePatientRegistrationById(id);
    }

    @GetMapping("/patientregister")
    public List<PatientRegistration> findAll(){
        return patientRegistrationService.getPatientRegistrations();
    }
}