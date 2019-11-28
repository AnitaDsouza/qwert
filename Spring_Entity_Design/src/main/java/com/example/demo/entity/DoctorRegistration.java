package com.example.demo.entity;

import java.sql.Blob;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Entity
@Table(name = "doctorregistration")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DoctorRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int doctor_id;
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	
	
	@Column(name = "specialist")
	private String specialist;
	
	
	@Column(name = "branch")
	private String branch;
	
	
	@Column(name = "fee")
	private long fee;
	
	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
	 * CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	 * 
	 * @JoinTable(name = "Appiontment_schedule", joinColumns = @JoinColumn(name =
	 * "doctor_id"), inverseJoinColumns = @JoinColumn(name = "schedule_id")) private
	 * List<DoctorSchedule> doctorSchedule;
	 */
	/*
	 * @Column(name = "photo") private Blob photo;
	 */
	

}