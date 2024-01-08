package tn.esprit.worker_examen.Service.Interface;

import tn.esprit.worker_examen.Entity.Type;
import tn.esprit.worker_examen.Entity.Worker;

import java.util.List;
import java.util.Map;

public interface WorkerInterface {
    public Worker addWork(Worker worker);
    public Worker affectWorkertoReservation(String nic, List<Long> idReservation);

    public Float calculateTotallncomePerWorker(String name, Type typeService);

    public void getReservation();

    public Map<String,Long> getListeServiceEtNBReservation();

}
