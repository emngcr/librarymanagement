package com.project.librarymanagement.repository;

import com.project.librarymanagement.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
