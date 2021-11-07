package com.vmts.app.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vmts.app.entity.Booking;
import com.vmts.app.entity.DriverRating;
import com.vmts.app.entity.ExecutiveRating;
import com.vmts.app.entity.InsuranceDtls;
import com.vmts.app.entity.RatingModel;
import com.vmts.app.entity.Vehicle;
import com.vmts.app.service.BookingService;
import com.vmts.app.service.VehicleService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;

	@Operation(summary="new booking")
	@PostMapping(value = "/add")
	void addBooking(@RequestBody Booking booking) {
		log.info("Inside BookingController's addBooking method");
		bookingService.addBooking(booking);
	}
	
	
	@Operation(summary="total booking in a period")
	@GetMapping(value = "/count")
	int countBooking(@RequestParam String startDate, @RequestParam String endDate) {
		log.info("Inside BookingController's countBooking method");
		return bookingService.countBooking(startDate, endDate);
	}
	
	@Operation(summary="Bookings need to settle")
	@GetMapping(value = "/settleCount")
	int settleCount() {
		log.info("Inside BookingController's settleCount method");
		return bookingService.settleCount();
	}
	
	@Operation(summary="Number of cancelled bookings")
	@GetMapping(value = "/cancelledCount")
	int cancelledCount() {
		log.info("Inside BookingController's cancelledCount method");
		return bookingService.cancelledCount();
	}
	
	@Operation(summary="No.of bookings assigned to a specific driver")
	@GetMapping(value = "/driverBookings")
	int driverBookings(@RequestParam int driverId) {
		log.info("Inside BookingController's driverBookings method");
		return bookingService.driverBookings(driverId);
	}
	
	
	
	
	@Operation(summary="Rate driver")
	@PostMapping(value = "/rate/driver")
	void rateDriver(@RequestBody RatingModel driverRating) {
		log.info("Inside BookingController's rateDriver method");
		bookingService.rateDriver(driverRating);
	}
	
	@Operation(summary="Rate executive")
	@PostMapping(value = "/rate/executive")
	void rateExecutive(@RequestBody RatingModel executiveRating) {
		log.info("Inside BookingController's rateExecutive method");
		bookingService.rateExecutive(executiveRating);
	}
	
	@Operation(summary="Driver involved with more number of penalties")
	@GetMapping(value = "/mostPenalties")
	int mostPenalties() {
		log.info("Inside BookingController's mostPenalties method");
		return bookingService.mostPenalties();
	}
	
	@Operation(summary="Total profit through bookings")
	@GetMapping(value = "/bookingProfit")
	int bookingProfit() {
		log.info("Inside BookingController's bookingProfit method");
		return bookingService.bookingProfit();
	}
	
}