package com.vmts.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class DriverBookingId implements Serializable{

	private static final long serialVersionUID = 6029160879567856645L;
	
	Integer bookingId;
	Integer driverId;
	
	public DriverBookingId(Integer bookingId, Integer driverId) {
		super();
		this.bookingId = bookingId;
		this.driverId = driverId;
	}

}
