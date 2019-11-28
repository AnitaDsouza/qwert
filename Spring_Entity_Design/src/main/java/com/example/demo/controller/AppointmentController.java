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

import com.example.demo.entity.Appointment;
import com.example.demo.sevice.AppointmentService;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment")
    public Appointment create(@RequestBody Appointment appointment){
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping(path = {"/appointment/{id}"})
    public Optional<Appointment> findOne(@PathVariable("id") int id){
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("/appointment")
    public Appointment update(@RequestBody Appointment appointment){
        return appointmentService.updatepatientregistration(appointment);
    }

    @DeleteMapping(path ={"/appointment/{id}"})
    public void delete(@PathVariable("id") int id) {
         appointmentService.deleteAppointmentById(id);
    }

    @GetMapping("/appointment")
    public List<Appointment> findAll(){
        return appointmentService.getAppointments();
    }
}