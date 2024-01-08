package tn.esprit.worker_examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.worker_examen.Entity.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
}
