package com.example.demo.sevice;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Feedback;
import com.example.demo.exception.ResourceNotFoundException;

public interface FeedbackService {

	List<Feedback> getAllFeedback();

	ResponseEntity<Feedback> getFeedbackById(Integer feedbackId) throws ResourceNotFoundException;

	Feedback createFeedback(Feedback feedback);

	ResponseEntity<Feedback> updateFeedback(Integer FeedbackId, Feedback feedbackDetails) throws ResourceNotFoundException;

	Map<String, Boolean> deleteFeedback(Integer feedbackId) throws ResourceNotFoundException;
	
	
}
