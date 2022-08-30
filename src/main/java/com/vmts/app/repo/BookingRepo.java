package com.vmts.app.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vmts.app.entity.Address;
import com.vmts.app.entity.Booking;


public interface BookingRepo extends CrudRepository<Booking, Integer> {

	@Query(value="SELECT COUNT(*) FROM VMTS.BOOKING WHERE START_DATE BETWEEN ?1 AND ?2 ",
			nativeQuery=true)
	int countBooking(String startDate, String endDate);

	@Query(value="SELECT COUNT(*) FROM VMTS.BOOKING WHERE BOOKING_STATUS = 'completed'", nativeQuery=true)
	int settleCount();

	@Query(value="SELECT COUNT(BOOKING_ID) FROM VMTS.BOOKING WHERE DRIVER_ID = ?1", nativeQuery=true)
	int driverBookings(int driverId);

	@Query(value="select MAX(count) from (select driver_id, count(penalty_charge) count from vmts.booking "
			+ "where penalty_charge <> 0 group by driver_id) AS Penalty_Count ", nativeQuery=true)
	int mostPenalties();

	@Query(value="select (sum(V.RENT_PER_DAY * ((B.END_DATE - B.START_DATE) + 1)) - sum(B.penalty_charge) "
			+ "- sum(F.fuel_filled_amount)) AS 'Total PROFIT' "
			+ "from VMTS.VEHICLE V, VMTS.Booking B, VMTS.fuel_dtls F "
			+ "where V.reg_no = B.vehicle_id "
			+ "AND B.booking_status = 'PAID' ",nativeQuery=true)
	int bookingProfit();

	@Query(value="SELECT COUNT(*) FROM VMTS.BOOKING WHERE BOOKING_STATUS = 'cancelled'", nativeQuery=true)
	int cancelledCount();
	
}
