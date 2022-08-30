package com.vmts.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmts.app.entity.Executive;
import com.vmts.app.entity.FuelDtls;
import com.vmts.app.entity.InsuranceDtls;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.repo.ExecutiveRepo;
import com.vmts.app.repo.FuelRepo;
import com.vmts.app.repo.InsuranceRepo;
import com.vmts.app.repo.VehicleRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExecutiveService {
	@Autowired
	ExecutiveRepo executiveRepo;

	/**
	 * Inserts executive details
	 * 
	 * @param executive
	 */
	public void addExecutive(Executive executive) {
		
		log.info("Inserting executive to the table: " + executive.toString());
		executiveRepo.save(executive);
	}

	public int countExecutives() {
		return executiveRepo.countExecutives();
	}
	
}
