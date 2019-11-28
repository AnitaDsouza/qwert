package com.example.demo.entity;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name = "branch")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Branch {
	@Id
	private String branch;

}
