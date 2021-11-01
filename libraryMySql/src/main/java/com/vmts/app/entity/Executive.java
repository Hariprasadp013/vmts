package com.vmts.app.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.vmts.app.enums.LicenseType;
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
@Table(name="EXECUTIVE")
public class Executive implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@Column(name="EMP_ID")
	Integer empId;
	
	@Column(name="RATING")
	double rating;

	public Executive(Integer empId, double rating) {
		super();
		this.empId = empId;
		this.rating = rating;
	}
}