package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="enquiry")
public class Enquiry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer enquiry_id;

	@Column(name="user_name")
	String userName;

	@Column(name="email")
	String email;

	@Column(name="branch")
	String branch;

	@Column(name="message")
	String message;

	public Enquiry(String userName, String email, String branch, String message) {
		super();
		this.userName = userName;
		this.email = email;
		this.branch = branch;
		this.message = message;
	}
	
	
	
}
