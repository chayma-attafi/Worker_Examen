package tn.esprit.worker_examen.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.worker_examen.Entity.Vehicle;
import tn.esprit.worker_examen.Service.Interface.VehicleInterface;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class VehicleController {
    VehicleInterface vehicleInterface;

    @PostMapping("/addVehicleReservationAndAffectToWashing/{idService}")
    public Vehicle addVehicleReservationAndAffectToWashing(@RequestBody Vehicle vehicle,
                                                           @PathVariable List<Long> idService) {
        return vehicleInterface.addVehicleReservationAndAffectToWashing(vehicle, idService);
    }
}
