package com.vmts.app.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vmts.app.entity.Driver;
import com.vmts.app.entity.Employee;
import com.vmts.app.entity.Executive;
import com.vmts.app.entity.Vehicle;


public interface ExecutiveRepo extends CrudRepository<Executive, Integer> {

	@Query(value="SELECT COUNT(*) FROM 	VMTS.EXECUTIVE", nativeQuery=true)
	int countExecutives();

}
