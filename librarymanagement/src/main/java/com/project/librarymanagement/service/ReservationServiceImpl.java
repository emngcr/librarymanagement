package com.project.librarymanagement.service;

import com.project.librarymanagement.entity.Reservation;
import com.project.librarymanagement.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservationServiceImpl implements ReservationService{
    private ReservationRepository reservationRepository;

    @Autowired
    ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }
    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation update(Reservation reservation, Long id) {
        Optional<Reservation> res = reservationRepository.findById(id);

        if (res.isPresent()){
            Reservation reservation1 = res.get();
            return reservation;
        }
        else {
            return null;// exception da firlatılabilir
        }
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
