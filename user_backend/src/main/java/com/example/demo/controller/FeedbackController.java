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

import com.example.demo.entity.Feedback;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.sevice.FeedbackService;

@RestController
@RequestMapping("/api")
public class FeedbackController {
	
	@Autowired
	private FeedbackService FeedbackService;
	
	@GetMapping("/feedbacks")
    public List<Feedback> getAllFeedback() {
        return FeedbackService.getAllFeedback();
    }

    @GetMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable(value = "id") Integer FeedbackId) throws ResourceNotFoundException {
       return FeedbackService.getFeedbackById(FeedbackId);
    }
    
    @PostMapping("/feedbacks")
    public Feedback createFeedback(@Valid @RequestBody Feedback Feedback) {
        return FeedbackService.createFeedback(Feedback);
    }

    @PutMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable(value = "id") Integer FeedbackId,
         @Valid @RequestBody Feedback FeedbackDetails) throws ResourceNotFoundException {
       return FeedbackService.updateFeedback(FeedbackId, FeedbackDetails);
    }

    @DeleteMapping("/feedbacks/{id}")
    public Map<String, Boolean> deleteFeedback(@PathVariable(value = "id") Integer FeedbackId)
         throws ResourceNotFoundException {
        return FeedbackService.deleteFeedback(FeedbackId);
    }
	
	

}
