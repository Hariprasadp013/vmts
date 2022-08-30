package com.vmts.app.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vmts.app.entity.Driver;
import com.vmts.app.entity.Employee;
import com.vmts.app.entity.FuelDtls;
import com.vmts.app.entity.Vehicle;


public interface FuelRepo extends CrudRepository<FuelDtls, String> {

	@Query(value="SELECT SUM(FUEL_FILLED_AMOUNT) FROM VMTS.FUEL_DTLS WHERE DATE_OF_FILLING < current_date() AND "
			+ "DATE_OF_FILLING > current_date()-30;",nativeQuery=true)
	double oneMonthFuelCost();

	@Query(value="select round((SUM(b.km_driven)/SUM(f.fuel_filled)),2) AS mileage from vmts.fuel_dtls f, vmts.booking b "
			+ "where f.vehicle_id=b.vehicle_id AND f.vehicle_id = ?1 ",nativeQuery=true)
	double calculateMileage(String regNo);

}
