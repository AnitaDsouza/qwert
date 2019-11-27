package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer doctor_id;
	
	@NotNull
	@Column(name = "first_name")
	String firstName;
	
	@Column(name = "last_name")
	String lastName;
	
	@Column(name = "gender")
	String gender;
	
	@Column(name="fee")
	double fee;
	
	@Column(name="speciality")
	String Speciality;
	
	@Column(name ="branch")
	String Branch;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "Appiontment_schedule", joinColumns = @JoinColumn(name = "doctor_id"), inverseJoinColumns = @JoinColumn(name = "schedule_id"))
	
	private List<DoctorSchedule> doctorSchedule;
	
	public Doctor(@NotNull String firstName, String lastName, String gender, double fee, String speciality,
			String branch) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.fee = fee;
		Speciality = speciality;
		Branch = branch;
	}
	
	
}
