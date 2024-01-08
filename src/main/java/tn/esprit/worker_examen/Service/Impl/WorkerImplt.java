package tn.esprit.worker_examen.Service.Impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.worker_examen.Entity.*;
import tn.esprit.worker_examen.Repository.ReservationRepository;
import tn.esprit.worker_examen.Repository.WashingRepository;
import tn.esprit.worker_examen.Repository.WorkerRepository;
import tn.esprit.worker_examen.Service.Interface.WorkerInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@Service
public class WorkerImplt implements WorkerInterface {
    WorkerRepository workerRepository;
    ReservationRepository reservationRepository;
    WashingRepository washingRepository;


    @Override
    public Worker addWork(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public Worker affectWorkertoReservation(String nic, List<Long> idReservation) {
        Worker w = workerRepository.findByNicLike(nic);
        List<Reservation> reservationList = reservationRepository.findAllById(idReservation);
        for (Reservation reservation: reservationList){

            if (reservationList.size() < 5) {
                reservation.setStatus(Status.CONFIRMED);
                reservation.setWorker(w);
                reservationRepository.save(reservation);
            }
            else {
                break;
            }
        }
        return workerRepository.save(w);
    }

    @Override
    public Float calculateTotallncomePerWorker(String name, Type typeService) {
        float mont=0;
        Worker w =workerRepository.findFirstByNameLike(name);

        for(Reservation r : w.getReservationList())
        {
            if(r.getStatus()==Status.CONFIRMED)
            {
                Washing_Service washingService = washingRepository.findFirstByType(typeService);
                mont+=washingService.getPrice();
            }
            else {
                break;
            }
        }
        return mont;
    }

    @Scheduled(fixedRate = 15000)//sedeclanche automatique sans faire excuter de la methode
    @Override
    public void getReservation() {
        for(Reservation r:reservationRepository.reservsbydate()){
            log.info(String.valueOf(r));
        }


    }

    @Override
    public Map<String, Long> getListeServiceEtNBReservation() {
        Map<String, Long> map=new HashMap<>();


        List<Washing_Service> washingServiceList = washingRepository.findAll();
        for (Washing_Service w : washingServiceList) {
            long reservationCount = reservationRepository.reservcountByWashingServiceType(w.getType());
            map.put(w.getType().name(), reservationCount);
        }
        return map;
    }



}
