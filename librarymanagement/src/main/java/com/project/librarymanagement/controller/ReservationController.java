package com.project.librarymanagement.controller;

import com.project.librarymanagement.entity.Reservation;
import com.project.librarymanagement.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private ReservationService reservationService;

    ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    @GetMapping
    public List<Reservation> getAllReservations(){
        return  reservationService.getAll();
    }
    @GetMapping("/{revervationid}")
    public Reservation getReservationById(@PathVariable Long id){
        return reservationService.getById(id);
    }
    @PostMapping
    public Reservation createReservaiton(@RequestBody Reservation reservation){
        return  reservationService.addReservation(reservation);
    }
    @PutMapping("/{reservationid}")
    public Reservation updateReservationById(@RequestBody Reservation reservation , @PathVariable Long id){
        return  reservationService.update(reservation , id);
    }
    @DeleteMapping("/{reservationid}")
    public void deleteReservationById(@PathVariable Long id){
        reservationService.delete(id);
    }
}
