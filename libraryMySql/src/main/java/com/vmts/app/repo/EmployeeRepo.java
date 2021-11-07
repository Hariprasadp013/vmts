package com.vmts.app.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vmts.app.entity.Employee;
import com.vmts.app.entity.Vehicle;


public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	
	@Query(value ="Select  *  from EMPLOYEE where SALARY =( select MAX(SALARY) from EMPLOYEE )"
			,nativeQuery=true)
	Employee findMaxSalary();

	@Query(value ="SELECT distinct CONCAT(A.FNAME,' ', A.LNAME) AS Highest_rated_employee FROM VMTS.EMPLOYEE A, VMTS.DRIVER B, "
			+ "	VMTS.EXECUTIVE E "
			+ "	WHERE  (A.EMP_ID = E.EMP_ID  AND E.RATING >= '4') "
			+ " OR 	(A.EMP_ID  = B.EMP_ID AND B.RATING >= '4') "
			,nativeQuery=true)
	List<String> findHighRatings();


}
