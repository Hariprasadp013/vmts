package com.vmts.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name="ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@Column(name="EMP_ID")
	Integer empId;
	
	@Column(name="LOCALITY")
	String locality;
	
	@Column(name="CITY")
	String city;
	
	@Column(name="STATE")
	String state;

	
	public Address(int empId, String locality, String city, String state) {
		super();
		this.empId = empId;
		this.locality = locality;
		this.city = city;
		this.state = state;
	}
	
}