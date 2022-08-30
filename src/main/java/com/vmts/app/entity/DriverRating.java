package com.vmts.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name="DRIVER_RATING")
public class DriverRating implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@EmbeddedId
	DriverBookingId id;
	
	@Column(name="RATING")
	double rating;

	public DriverRating(DriverBookingId id, double rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
}