package tn.esprit.worker_examen.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.worker_examen.Entity.Reservation;
import tn.esprit.worker_examen.Entity.Type;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    @Query("select r from Reservation r  order by r.timereservation  ")
    List<Reservation> reservsbydate();

    //@Query("SELECT count(*) from Reservation r,Washing_Service w where w member of r.washingServiceList")
    //long reservcount();
    @Query("SELECT count(r) FROM Reservation r JOIN r.washingServiceList w WHERE w.type = :type")
    long reservcountByWashingServiceType(@Param("type") Type type);

}
