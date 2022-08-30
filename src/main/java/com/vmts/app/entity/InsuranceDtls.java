package com.vmts.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.vmts.app.enums.VehicleType;
import com.vmts.app.util.DateHandler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name="INSURANCE_DTLS")
public class InsuranceDtls implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@Column(name="INSURANCE_ID")
	String insuranceId;
	
	@Column(name="DATE_TAKEN")
	@JsonDeserialize(using = DateHandler.class)
	Date dateTaken;
	
	@Column(name="EXPIRY_DATE")
	@JsonDeserialize(using = DateHandler.class)
	Date expiryDate;
	
	@Column(name="AMOUNT")
	double amount;	
	
	@Column(name="NO_OF_CLAIMS")
	Integer noOfClaims;

	public InsuranceDtls(String insuranceId, Date dateTaken, Date expiryDate, double amount, Integer noOfClaims) {
		super();
		this.insuranceId = insuranceId;
		this.dateTaken = dateTaken;
		this.expiryDate = expiryDate;
		this.amount = amount;
		this.noOfClaims = noOfClaims;
	}
	
}