package com.vmts.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vmts.app.util.DateHandler;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMP_ID")
	Integer empId;
	
	@Column(name="FNAME")
	String fname;
	
	@Column(name="LNAME")
	String lname;
	
	@Column(name="DOJ")
	@JsonDeserialize(using = DateHandler.class)
	Date doj;
	
	@Column(name="PHONE")
	Integer phone;
	
	@Column(name="JOB_TYPE")
	String jobType;
	
	@Column(name="SALARY")
	Integer salary;

	public Employee(String fname, String lname, Date doj, int phone, String jobType, int salary) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.doj = doj;
		this.phone = phone;
		this.jobType = jobType;
		this.salary = salary;
	}
}