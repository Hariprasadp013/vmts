package com.vmts.app.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class ExecutiveBookingId implements Serializable{
	private static final long serialVersionUID = 4987567550446023589L;
	
	Integer bookingId;
	Integer executiveId;
	
	public ExecutiveBookingId(Integer bookingId, Integer executiveId) {
		super();
		this.bookingId = bookingId;
		this.executiveId = executiveId;
	}

}
