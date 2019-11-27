package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedback_id;
	
	@Column(name = "feedback_message")
	private String feedbackMessage;
	
	@Column(name = "rate")
	private Integer rate;
	
	@Column(name = "user_mail")
	private String userMail;

	public Feedback(String feedbackMessage, Integer rate, String userMail) {
		super();
		this.feedbackMessage = feedbackMessage;
		this.rate = rate;
		this.userMail = userMail;
	}
		
}
