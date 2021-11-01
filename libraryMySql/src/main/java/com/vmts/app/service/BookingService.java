package com.vmts.app.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vmts.app.entity.Address;
import com.vmts.app.entity.Booking;
import com.vmts.app.entity.CustomerDtls;
import com.vmts.app.entity.Driver;
import com.vmts.app.entity.DriverBookingId;
import com.vmts.app.entity.DriverRating;
import com.vmts.app.entity.Employee;
import com.vmts.app.entity.ExecutiveBookingId;
import com.vmts.app.entity.ExecutiveRating;
import com.vmts.app.entity.RatingModel;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.repo.AddressRepo;
import com.vmts.app.repo.BookingRepo;
import com.vmts.app.repo.CustomerRepo;
import com.vmts.app.repo.DriverRatingRepo;
import com.vmts.app.repo.DriverRepo;
import com.vmts.app.repo.EmployeeRepo;
import com.vmts.app.repo.ExecutiveRatingRepo;
import com.vmts.app.repo.VehicleRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookingService {
	@Autowired
	BookingRepo bookingRepo;
	
	@Autowired
	DriverRatingRepo driverRatingRepo;
	
	@Autowired
	ExecutiveRatingRepo executiveRatingRepo;
	
	/**
	 * Add new Booking
	 * 
	 * @param booking
	 */
	public void addBooking(Booking booking) {
		
		log.info("Inserting new booking to the table: " + booking.toString());
		bookingRepo.save(booking);
	}

	public void rateDriver(RatingModel driverRating) {
		log.info("Inserting driver rating: " + driverRating.toString());
		DriverBookingId id = new DriverBookingId(driverRating.getBookingId(), driverRating.getDriverId());
		DriverRating entity = new DriverRating(id, driverRating.getRating());
		driverRatingRepo.save(entity);
		
	}
	
	public void rateExecutive(RatingModel executiveRating) {
		log.info("Inserting executive rating: " + executiveRating.toString());
		
		ExecutiveBookingId id = new ExecutiveBookingId(executiveRating.getBookingId(), executiveRating.getExecutiveId());
		ExecutiveRating entity = new ExecutiveRating(id, executiveRating.getRating());
		executiveRatingRepo.save(entity);
		
	}
}
