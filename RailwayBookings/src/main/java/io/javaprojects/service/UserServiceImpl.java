package io.javaprojects.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.javaprojects.Repository.BookingsRepo;
import io.javaprojects.Repository.UserRepo;
import io.javaprojects.model.Bookings;
import io.javaprojects.model.User;
import io.javaprojects.web.dto.BookingDto;
import io.javaprojects.web.dto.UserLoginDto;
import io.javaprojects.web.dto.UserRegistrationDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo repo;
	@Autowired
	private BookingsRepo bookingsRepo;

	@Override
	public User save(UserRegistrationDTO dto) {
		User user = new User(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getPhone(), dto.getPassword());

		return repo.save(user);
	}

	public boolean login(UserLoginDto dto) {
		Optional<User> findUserByEmail = repo.findByEmail(dto.getEmailOrPhone());
		Optional<User> findUserByPhone = repo.findByPhone(dto.getEmailOrPhone());
		if (findUserByEmail.isEmpty() && findUserByPhone.isEmpty())
			return false;

		if (findUserByEmail.isEmpty() == false) {
			User user = findUserByEmail.get();
			if (dto.getPassword().equals(user.getPassword())) {
				return true;
			}
		} else if (findUserByPhone.isEmpty() == false) {
			User user = findUserByPhone.get();
			if (dto.getPassword().equals(user.getPassword())) {
				return true;
			}
		}
		return false;

	}

	public Long getUserId(UserLoginDto dto) {

		Optional<User> findUserByEmail = repo.findByEmail(dto.getEmailOrPhone());
		Optional<User> findUserByPhone = repo.findByPhone(dto.getEmailOrPhone());
		if (findUserByEmail.isEmpty() == false) {
			User user = findUserByEmail.get();
			return user.getId();
		} else {
			User user = findUserByPhone.get();
			return user.getId();
		}
	}

	@SuppressWarnings("deprecation")
	public User getUser(Long id) {
		return repo.getById(id);
	}

	public void deleteUser(Long id) {
		repo.deleteById(id);
	}

	public void addUser(User user) {
		repo.save(user);
	}

	public void addBookings(BookingDto bookingDto) {

		bookingsRepo.save(new Bookings(bookingDto.getFromStation(), bookingDto.getToStation(), bookingDto.getTiming()));
	}

	public List<Bookings> getAllBookings(long id) {
		List<Bookings> list = repo.getById(id).getBookings();
		return list;
	}

	public void addStation(BookingDto bookingDto) {
		bookingsRepo.save(new Bookings(bookingDto.getFromStation(), bookingDto.getToStation(), bookingDto.getTiming()));
	}

}
