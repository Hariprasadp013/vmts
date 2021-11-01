package com.vmts.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmts.app.entity.FuelDtls;
import com.vmts.app.entity.InsuranceDtls;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.repo.FuelRepo;
import com.vmts.app.repo.InsuranceRepo;
import com.vmts.app.repo.VehicleRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FuelService {
	@Autowired
	FuelRepo fuelRepo;

	/**
	 * Inserts fuel details
	 * 
	 * @param fuelDtls
	 */
	public void addFuelDtls(FuelDtls fuelDtls) {
		
		log.info("Inserting fuelDtls to the table: " + fuelDtls.toString());
		fuelRepo.save(fuelDtls);
	}
	
}
