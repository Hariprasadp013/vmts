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

import com.vmts.app.enums.CustomerType;
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
@Table(name="CUSTOMER_DTLS")
public class CustomerDtls implements Serializable {
	private static final long serialVersionUID = 2236918422169647799L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	Integer customerId;

	@Enumerated(EnumType.STRING)
	@Column(name="CUSTOMER_TYPE", columnDefinition="ENUM('govt','private')")
	CustomerType customerType;
	
	@Column(name="ORG_NAME")
	String orgName;	
}