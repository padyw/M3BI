package com.pramod.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pramod.entity.Booking;
import com.pramod.entity.Hotel;
import com.pramod.entity.PendingApproval;
import com.pramod.entity.User;
import com.pramod.exceptions.BookingNotFoundException;
import com.pramod.exceptions.HotelNotFoundException;
import com.pramod.exceptions.PendingApprovalNotFoundException;
import com.pramod.exceptions.UserNotFoundException;
import com.pramod.repository.BookingRepository;
import com.pramod.repository.HotelRepository;
import com.pramod.repository.PendingApprovalRepository;
import com.pramod.repository.UserRepository;

@Service
public class BookingService {

	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	UserRepository userRepository;
		
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	PendingApprovalRepository pendingApprovalRepository;
	
	public Hotel getHotelStatus(int hotelId) {
		Optional<Hotel> hotel = hotelRepository.findById(hotelId);
		if(!hotel.isPresent())
			throw new HotelNotFoundException("Hotel Id "+hotelId+" not found.");
		return hotel.get();
	}

	public User getuser(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("User Id "+ userId+ " not found");
		return user.get();
	}

	public int checkHotelPrice(Hotel hotel) {
		return hotel.getPrice();
	}

	public int checkUserBonusPoints(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("User Id "+ userId+ " not found");
		return user.get().getBonusPoints();
	}

	public Hotel updateHotelStatus(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	public Booking updateBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	public PendingApproval updatePendingApprovalTable(PendingApproval pendingApproval) {
		 return pendingApprovalRepository.save(pendingApproval);
	}

	public PendingApproval searchPreviousBookingByHotelId(int id) {
		Optional<PendingApproval> pendingApproval = pendingApprovalRepository.findByHotelId(id);
		if(!pendingApproval.isPresent())
			throw new PendingApprovalNotFoundException("Pending Approval id "+id+" not found.");
		return pendingApproval.get();
	}

	public void deletePreviousBooking(int id) {
		pendingApprovalRepository.deleteById(id);
	}

	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(int id) {
		Optional<Booking> booking = bookingRepository.findById(id);
		if(!booking.isPresent())
			throw new BookingNotFoundException("Booking Id "+ id+" not found");
		return booking.get();
	}

	public Booking getBookingByUserId(int userId) {
		Optional<Booking> booking = bookingRepository.findByUserId(userId);
		if(!booking.isPresent())
			throw new BookingNotFoundException("Booking Id "+ userId+" not found");
		return booking.get();
	}

	
}
