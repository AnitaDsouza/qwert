package com.example.demo.entity;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "patientregistration")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatientRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patient_id;
	@Column(name = "userId" ,unique= true)
	private String userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email" ,unique= true)
	private String email;
	@Column(name = "date_of_birth")
	private Date dateofbirth;
	@Column(name = "age")
	private int age;
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "Adress")
	private String Address;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "pincode")
	private int pincode;
	@Column(name = "phone")
	private Long phone;
	private String password;

	

}