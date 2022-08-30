package com.vmts.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RatingModel {
	int bookingId;
	int driverId;
	int executiveId;
	int rating;
	public RatingModel(int bookingId, int driverId, int executiveId, int rating) {
		super();
		this.bookingId = bookingId;
		this.driverId = driverId;
		this.executiveId = executiveId;
		this.rating = rating;
	}
}
