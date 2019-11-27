package com.example.demo.sevice;
 import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Feedback;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.FeedbackRepository;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
    private FeedbackRepository feedbackRepository;
	
	  
		@Override
		@Transactional
	    public List<Feedback> getAllFeedback() {
	        return feedbackRepository.findAll();
	    }

	   
		@Override
		@Transactional
	    public ResponseEntity<Feedback> getFeedbackById(Integer feedbackId) throws ResourceNotFoundException
	    {
	    	Feedback feedback = feedbackRepository.findById(feedbackId)
	          .orElseThrow(() -> new ResourceNotFoundException("Feedback not found for this id :: " + feedbackId));
	        return ResponseEntity.ok().body(feedback);
	    }
	    
		@Override
		@Transactional
	    public Feedback createFeedback(Feedback feedback) 
	    {
	        return feedbackRepository.save(feedback);
	    }

		@Override
		@Transactional
	    public ResponseEntity<Feedback> updateFeedback(Integer feedbackId, Feedback feedbackDetails) throws ResourceNotFoundException
	    {
	        Feedback feedback = feedbackRepository.findById(feedbackId)
	        .orElseThrow(() -> new ResourceNotFoundException("Feedback not found for this id :: " + feedbackId));

	        	feedback.setUserMail(feedbackDetails.getUserMail());
	        	feedback.setFeedbackMessage(feedbackDetails.getFeedbackMessage());
	        	feedback.setRate(feedbackDetails.getRate());
	        Feedback updatedFeedback = feedbackRepository.save(feedback);
	        return ResponseEntity.ok(updatedFeedback);
	    }

	    
		@Override
		@Transactional
	    public Map<String, Boolean> deleteFeedback(Integer feedbackId) throws ResourceNotFoundException {

	        Feedback feedback = feedbackRepository.findById(feedbackId).orElseThrow(() -> new ResourceNotFoundException("Feedback not found for this id :: " + feedbackId));
	        feedbackRepository.delete(feedback);
	        Map<String, Boolean> response = new HashMap<>();
	        response.put("deleted", Boolean.TRUE);
	        return response;
	    }
}