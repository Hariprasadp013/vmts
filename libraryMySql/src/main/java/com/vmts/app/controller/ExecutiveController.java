package com.vmts.app.controller;

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

import com.vmts.app.entity.Executive;
import com.vmts.app.entity.FuelDtls;
import com.vmts.app.entity.InsuranceDtls;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.service.ExecutiveService;
import com.vmts.app.service.FuelService;
import com.vmts.app.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/executive")
public class ExecutiveController {
	
	@Autowired
	ExecutiveService executiveService;

	@Operation(summary="Add executive")
	@PostMapping(value = "/add")
	void addExecutive(@RequestBody Executive executive) {
		log.info("Inside ExecutiveController's addExecutive method");
		executiveService.addExecutive(executive);
	}
	
}
