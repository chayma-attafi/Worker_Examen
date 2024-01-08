package tn.esprit.worker_examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.worker_examen.Entity.Type;
import tn.esprit.worker_examen.Entity.Washing_Service;

@Repository
public interface WashingRepository extends JpaRepository<Washing_Service,Long> {
    Washing_Service findFirstByType(Type type);
}
