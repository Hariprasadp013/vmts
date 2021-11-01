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

import com.vmts.app.enums.BookingStatus;
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
@Table(name="BOOKING")
public class Booking implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BOOKING_ID")
	Integer bookingId;
	
	@Column(name="VEHICLE_ID")
	String vehicleId;
	
	@Column(name="CUSTOMER_ID")
	Integer customerId;
	
	@Column(name="DRIVER_ID")
	Integer driverId;
	
	@Column(name="EXECUTIVE_ID")
	Integer executiveId;
	
	@Column(name="START_DATE")
	@JsonDeserialize(using = DateHandler.class)
	Date startDate;
	
	@Column(name="END_DATE")
	@JsonDeserialize(using = DateHandler.class)
	Date endDate;
	
	@Column(name="PENALTY_CHARGE")
	double penaltyCharge;
	
	@Column(name="KM_DRIVEN")
	double kmDriven;
	
	@Column(name="INSURANCE_CLAIM_AMOUNT")
	double insuranceClaimAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="BOOKING_STATUS", columnDefinition="ENUM('paid','booked','completed','cancelled','confirmed')")
	BookingStatus bookingStatus;

	public Booking(String vehicleId, Integer customId, Integer driverId, Integer executiveId, Date startDate,
			Date endDate, double penaltyCharge, double kmDriven, double insuranceClaimAmount,
			BookingStatus bookingStatus) {
		super();
		this.vehicleId = vehicleId;
		this.customerId = customId;
		this.driverId = driverId;
		this.executiveId = executiveId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.penaltyCharge = penaltyCharge;
		this.kmDriven = kmDriven;
		this.insuranceClaimAmount = insuranceClaimAmount;
		this.bookingStatus = bookingStatus;
	}
	
	
}