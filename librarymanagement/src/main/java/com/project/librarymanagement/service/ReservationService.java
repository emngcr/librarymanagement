package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAll();
    Reservation addReservation(Reservation reservation);
    Reservation getById(Long id);
    Reservation update(Reservation reservation ,Long id);
    void delete(Long id);
}
