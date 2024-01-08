package tn.esprit.worker_examen.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.worker_examen.Entity.Type;
import tn.esprit.worker_examen.Entity.Worker;
import tn.esprit.worker_examen.Service.Interface.WorkerInterface;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class WorkerController {
    WorkerInterface workerInterface;

    @PostMapping("/addWork")
    public Worker addWork(@RequestBody Worker worker) {
        return workerInterface.addWork(worker);
    }

    @PostMapping("/affectWorkertoReservation/{nic}/{idReservation}")
    public Worker affectWorkertoReservation(@PathVariable("nic") String nic,
                                            @PathVariable("idReservation") List<Long> idReservation) {
        return workerInterface.affectWorkertoReservation(nic, idReservation);
    }

    @PutMapping("/calculateTotallncomePerWorker/{name}/{typeService}")
    public Float calculateTotallncomePerWorker(@PathVariable("name") String name,
                                               @PathVariable("typeService") Type typeService) {
        return workerInterface.calculateTotallncomePerWorker(name, typeService);
    }

    @GetMapping("/getReservation")
    public void getReservation() {
        workerInterface.getReservation();
    }

    @GetMapping("/getListeServiceEtNBReservation")
    public Map<String, Long> getListeServiceEtNBReservation() {
        return workerInterface.getListeServiceEtNBReservation();
    }
}
