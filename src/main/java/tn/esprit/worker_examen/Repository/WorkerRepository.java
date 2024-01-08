package tn.esprit.worker_examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.worker_examen.Entity.Type;
import tn.esprit.worker_examen.Entity.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {

    Worker findByNicLike(String nic);
    Worker findFirstByNameLike(String name);
}
