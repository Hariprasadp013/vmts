package com.vmts.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		log.info("Inside EmployeeController's updateAddress method");
		employeeService.updateAddress(address);
	}
	
	@Operation(summary="Employee with maximum salary")
	@GetMapping(value = "/maxSalary")
	Map<String, Object> maxSalary() {
		log.info("Inside EmployeeController's maxSalary method");
		Optional<Employee> maxEmployee = employeeService.maxSalary();
		Map<String, Object> response = new HashMap<>();
		response.put("Name", maxEmployee.get().getFname()+" " + maxEmployee.get().getLname());
		response.put("Salary", maxEmployee.get().getSalary());
		return response;
	}
	
	@Operation(summary="Employee with rating >=4")
	@GetMapping(value = "/highRatings")
	Optional<List<String>> highRatings() {
		log.info("Inside EmployeeController's highRatings method");
		Optional<List<String>> maxEmployee = employeeService.highRatings();
		return maxEmployee;
	}
}
