package com.vmts.app.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmts.app.entity.InsuranceDtls;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;

	@Operation(summary="Insert a Vehicle")
	@PostMapping(value = "/add")
	void addNewVehicle(@RequestBody Vehicle vehicle) {
		log.info("Inside VehicleController's addNewVehicle method");
		vehicleService.insertNewVehicle(vehicle);
	}
	
	@Operation(summary="Updates vehicle insurance")
	@PostMapping(value = "/insurance")
	void updateInsurance(@RequestBody InsuranceDtls insuranceDtls) {
		log.info("Inside VehicleController's updateInsurance method");
		vehicleService.updateInsurance(insuranceDtls);
	}
	
	
}
