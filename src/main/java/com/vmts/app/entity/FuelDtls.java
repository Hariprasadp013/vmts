package com.vmts.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
@Table(name="FUEL_DTLS")
public class FuelDtls implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@Column(name="VEHICLE_ID")
	String vehicleId;
	
	@Column(name="FUEL_FILLED_AMOUNT")
	double fuelFilledamount;
	
	@Column(name="DATE_OF_FILLING")
	@JsonDeserialize(using = DateHandler.class)
	Date dateOfFilling;

	public FuelDtls(String vehicleId, double amount, Date date) {
		super();
		this.vehicleId = vehicleId;
		this.fuelFilledamount = amount;
		this.dateOfFilling = date;
	}
}