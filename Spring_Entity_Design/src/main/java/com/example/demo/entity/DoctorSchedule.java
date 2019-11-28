package com.example.demo.entity;

import java.sql.Blob;
import java.util.Date;
import java.util.List;
import java.sql.Time;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "doctorschedule")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DoctorSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int schedule_id;
	@Column(name = "date_ofavalabilty")
	private Date Date_Of_Avalability;
	
	@Column(name = "time")
	private Time Time;
	
	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST,
	 * CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	 * 
	 * @JoinTable(name = "Appiontment_schedule", joinColumns = @JoinColumn(name =
	 * "schedule_id"), inverseJoinColumns = @JoinColumn(name = "doctor_id")) private
	 * List<DoctorRegistration> doctorregistration;
	 */
}