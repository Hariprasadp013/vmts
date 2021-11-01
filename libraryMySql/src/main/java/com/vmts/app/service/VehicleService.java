package com.vmts.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmts.app.entity.InsuranceDtls;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.repo.InsuranceRepo;
import com.vmts.app.repo.VehicleRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VehicleService {
	@Autowired
	VehicleRepo vehicleRepo;

	@Autowired
	InsuranceRepo insuranceRepo;
	/**
	 * Inserts new vehicle to DB
	 * 
	 * @param vehicle
	 */
	public void insertNewVehicle(Vehicle vehicle) {
		
		log.info("Inserting vehicle to the table: " + vehicle.toString());
		vehicleRepo.save(vehicle);
	}
	
	/**
	 * Updates insurance details
	 * 
	 * @param insuranceDtls
	 */
	public void updateInsurance(InsuranceDtls insuranceDtls) {
		
		log.info("Updates insurance for : " + insuranceDtls.toString());
		insuranceRepo.save(insuranceDtls);
	}
}
