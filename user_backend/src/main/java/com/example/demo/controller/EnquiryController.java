package com.example.demo.controller;
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

import com.example.demo.entity.Enquiry;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.sevice.EnquiryService;

@RestController
@RequestMapping("/api")
public class EnquiryController {
	
	@Autowired
	private EnquiryService enquiryService;
	
	@GetMapping("/enquirys")
    public List<Enquiry> getAllEnquiry() {
        return enquiryService.getAllEnquiry();
    }

    @GetMapping("/enquirys/{id}")
    public ResponseEntity<Enquiry> getEnquiryById(@PathVariable(value = "id") Integer enquiryId) throws ResourceNotFoundException {
       return enquiryService.getEnquiryById(enquiryId);
    }
    
    @PostMapping("/enquirys")
    public Enquiry createEnquiry(@Valid @RequestBody Enquiry enquiry) {
        return enquiryService.createEnquiry(enquiry);
    }

    @PutMapping("/enquirys/{id}")
    public ResponseEntity<Enquiry> updateEnquiry(@PathVariable(value = "id") Integer enquiryId,
         @Valid @RequestBody Enquiry enquiryDetails) throws ResourceNotFoundException {
       return enquiryService.updateEnquiry(enquiryId, enquiryDetails);
    }

    @DeleteMapping("/enquirys/{id}")
    public Map<String, Boolean> deleteEnquiry(@PathVariable(value = "id") Integer enquiryId)
         throws ResourceNotFoundException {
        return enquiryService.deleteEnquiry(enquiryId);
    }
	
	

}
