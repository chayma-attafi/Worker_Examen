package tn.esprit.worker_examen.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.worker_examen.Entity.Washing_Service;
import tn.esprit.worker_examen.Service.Interface.WashingInterface;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/")
public class WashingController {
    WashingInterface washingInterface;

    @PostMapping("/addWashingServce")
    public void addWashingServce(@RequestBody List<Washing_Service> washingServiceList) {
        washingInterface.addWashingServce(washingServiceList);
    }
}
