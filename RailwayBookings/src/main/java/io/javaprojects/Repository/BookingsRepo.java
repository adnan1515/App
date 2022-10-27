package io.javaprojects.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.javaprojects.model.Bookings;

@Repository
public interface BookingsRepo extends JpaRepository<Bookings, Long> {

}
