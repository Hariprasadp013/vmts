package com.vmts.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmts.app.entity.Employee;
import com.vmts.app.service.EmployeeService;
import com.vmts.app.entity.Address;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Operation(summary="Add an employee")
	@PostMapping(value = "/add")
	void addNewEmployee(@RequestBody Employee employee) {
		log.info("Inside EmployeeController's addNewEmployee method");
		employeeService.insertNewEmployee(employee);
	}
	
	@Operation(summary="Add an employee")
	@PostMapping(value = "/address")
	void updateAddress(@RequestBody Address address) {
		log.info("Inside EmployeeController's addNewEmployee method");
		employeeService.updateAddress(address);
	}
}
