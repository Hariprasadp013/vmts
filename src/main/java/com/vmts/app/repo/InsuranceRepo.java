package com.vmts.app.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vmts.app.entity.Driver;
import com.vmts.app.entity.Employee;
import com.vmts.app.entity.InsuranceDtls;
import com.vmts.app.entity.Vehicle;


public interface InsuranceRepo extends CrudRepository<InsuranceDtls, Integer> {

	@Query(value="SELECT A.NO_OF_CLAIMS FROM VMTS.INSURANCE_DTLS A,VMTS.VEHICLE B  WHERE B.INSURANCE_NO = A.INSURANCE_ID AND "
			+ " B.REG_NO = ?1",nativeQuery=true)
	int insuranceClaims(String regId);

}
