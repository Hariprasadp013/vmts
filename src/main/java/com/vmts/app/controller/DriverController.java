package com.vmts.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmts.app.entity.Employee;
import com.vmts.app.service.DriverService;
import com.vmts.app.service.EmployeeService;
import com.vmts.app.entity.Address;
import com.vmts.app.entity.Driver;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/driver")
public class DriverController {

	@Autowired
	DriverService driverService;

	@Operation(summary="Add a driver")
	@PostMapping(value = "/add")
	void addNewDriver(@RequestBody Driver driver) {
		log.info("Inside DriverController's addNewDriver method");
		driverService.addDriver(driver);
	}
	
}
