package com.example.demo.sevice;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Enquiry;
import com.example.demo.exception.ResourceNotFoundException;

public interface EnquiryService {

	List<Enquiry> getAllEnquiry();

	ResponseEntity<Enquiry> getEnquiryById(Integer enquiryId) throws ResourceNotFoundException;

	Enquiry createEnquiry(Enquiry enquiry);

	ResponseEntity<Enquiry> updateEnquiry(Integer enquiryId, Enquiry enquiryDetails) throws ResourceNotFoundException;

	Map<String, Boolean> deleteEnquiry(Integer enquiryId) throws ResourceNotFoundException;
	
	
}
