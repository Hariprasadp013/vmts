package com.vmts.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmts.app.entity.Address;
import com.vmts.app.entity.Driver;
import com.vmts.app.entity.Employee;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.repo.AddressRepo;
import com.vmts.app.repo.DriverRepo;
import com.vmts.app.repo.EmployeeRepo;
import com.vmts.app.repo.VehicleRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	AddressRepo addressRepo;

	/**
	 * Inserts new vehicle to DB
	 * 
	 * @param book
	 */
	public void insertNewEmployee(Employee employee) {
		
		log.info("Inserting new employee to the table: " + employee.toString());
		employeeRepo.save(employee);
	}

	public void updateAddress(Address address) {
		log.info("Inserting address to the table: " + address.toString());
		addressRepo.save(address);
		
	}
}
