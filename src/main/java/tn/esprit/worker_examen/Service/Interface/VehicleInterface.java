package tn.esprit.worker_examen.Service.Interface;

import tn.esprit.worker_examen.Entity.Vehicle;

import java.util.List;

public interface VehicleInterface {
    public Vehicle addVehicleReservationAndAffectToWashing(Vehicle vehicle, List<Long> idService);
}
