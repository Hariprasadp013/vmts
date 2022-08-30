package com.vmts.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vmts.app.enums.VehicleType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Table(name="VEHICLE")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@Column(name="REG_NO")
	String regNo;
	
	@Column(name="FUEL_TYPE")
	String fuelType;
	
	@Column(name="INSURANCE_NO")
	String insuranceNo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="VEHICLE_TYPE", columnDefinition="ENUM('lmv','hmv')")
	VehicleType vehicleType;
	
	@Column(name="RENT_PER_DAY")
	double rentPerDay;	

	public Vehicle(String regNo, String fuelType, String insuranceNo, VehicleType vehicleType, double rent) {
		super();
		this.regNo = regNo;
		this.fuelType = fuelType;
		this.insuranceNo = insuranceNo;
		this.vehicleType = vehicleType;
		this.rentPerDay = rent;
	}
}