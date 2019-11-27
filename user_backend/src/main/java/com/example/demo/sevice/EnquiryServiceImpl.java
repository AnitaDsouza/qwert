package com.example.demo.sevice;
 import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Enquiry;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EnquiryRepository;


@Service
public class EnquiryServiceImpl implements EnquiryService {
	
	@Autowired
    private EnquiryRepository enquiryRepository;
	
	  
		@Override
		@Transactional
	    public List<Enquiry> getAllEnquiry() {
	        return enquiryRepository.findAll();
	    }

	   
		@Override
		@Transactional
	    public ResponseEntity<Enquiry> getEnquiryById(Integer enquiryId) throws ResourceNotFoundException
	    {
	    	Enquiry enquiry = enquiryRepository.findById(enquiryId)
	          .orElseThrow(() -> new ResourceNotFoundException("Enquiry not found for this id :: " + enquiryId));
	        return ResponseEntity.ok().body(enquiry);
	    }
	    
		@Override
		@Transactional
	    public Enquiry createEnquiry(Enquiry enquiry) 
	    {
	        return enquiryRepository.save(enquiry);
	    }

		@Override
		@Transactional
	    public ResponseEntity<Enquiry> updateEnquiry(Integer enquiryId, Enquiry enquiryDetails) throws ResourceNotFoundException
	    {
	        Enquiry enquiry = enquiryRepository.findById(enquiryId)
	        .orElseThrow(() -> new ResourceNotFoundException("ENQUIRY not found for this id :: " + enquiryId));

	        enquiry.setBranch(enquiryDetails.getBranch());
	        enquiry.setUserName(enquiryDetails.getUserName());
	        enquiry.setEmail(enquiryDetails.getEmail());
	        enquiry.setMessage(enquiryDetails.getMessage());
	        
	        Enquiry updatedEnquiry = enquiryRepository.save(enquiry);
	        return ResponseEntity.ok(updatedEnquiry);
	    }

	    
		@Override
		@Transactional
	    public Map<String, Boolean> deleteEnquiry(Integer enquiryId) throws ResourceNotFoundException {

	        Enquiry enquiry = enquiryRepository.findById(enquiryId).orElseThrow(() -> new ResourceNotFoundException("enquiry not found for this id :: " + enquiryId));
	        enquiryRepository.delete(enquiry);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}