package com.vmts.app.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vmts.app.entity.Driver;
import com.vmts.app.entity.Employee;
import com.vmts.app.entity.ExecutiveBookingId;
import com.vmts.app.entity.ExecutiveRating;
import com.vmts.app.entity.Vehicle;


public interface ExecutiveRatingRepo extends CrudRepository<ExecutiveRating, ExecutiveBookingId> {

}
