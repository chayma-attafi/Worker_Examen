package tn.esprit.worker_examen.Service.Impl;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.worker_examen.Entity.Reservation;
import tn.esprit.worker_examen.Entity.Status;
import tn.esprit.worker_examen.Entity.Vehicle;
import tn.esprit.worker_examen.Entity.Washing_Service;
import tn.esprit.worker_examen.Repository.ReservationRepository;
import tn.esprit.worker_examen.Repository.VehicleRepository;
import tn.esprit.worker_examen.Repository.WashingRepository;
import tn.esprit.worker_examen.Service.Interface.VehicleInterface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class VehicleImplt implements VehicleInterface {

    VehicleRepository vehicleRepository;
    ReservationRepository reservationRepository;
    WashingRepository washingRepository;

    @Transactional
    @Override
    public Vehicle addVehicleReservationAndAffectToWashing(Vehicle vehicle, List<Long> idService) {

        Reservation reservation = new Reservation();
        //set Status
        reservation.setStatus(Status.PENDING);
        //changer date
        reservation.setTimereservation(LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour() + 2, LocalDateTime.now().getMinute()));
        //trouver la list de washing service
        List<Washing_Service> washingServiceList = washingRepository.findAllById(idService);
        //affecter washing service to reservation
        reservation.setWashingServiceList(washingServiceList);
        reservation = reservationRepository.save(reservation);

        List<Reservation> reservations = new ArrayList<>();
        //affecter reservation au vehcule
        reservations.add(reservation);
        vehicle.setReservationList(reservations);

        return vehicleRepository.save(vehicle);
    }




}