package com.vmts.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vmts.app.entity.Employee;
import com.vmts.app.service.CustomerService;
import com.vmts.app.service.DriverService;
import com.vmts.app.service.EmployeeService;
import com.vmts.app.entity.Address;
import com.vmts.app.entity.CustomerDtls;
import com.vmts.app.entity.Driver;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Operation(summary="Add a Customer")
	@PostMapping(value = "/add")
	void addNewCustomer(@RequestBody CustomerDtls customerDtls) {
		log.info("Inside CustomerController's addNewCustomer method");
		customerService.addCustomer(customerDtls);
	}
	
}
