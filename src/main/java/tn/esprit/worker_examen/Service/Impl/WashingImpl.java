package tn.esprit.worker_examen.Service.Impl;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.worker_examen.Entity.Washing_Service;
import tn.esprit.worker_examen.Repository.WashingRepository;
import tn.esprit.worker_examen.Service.Interface.WashingInterface;

import java.util.List;

@AllArgsConstructor
@Service
public class WashingImpl implements WashingInterface {

    WashingRepository washingRepository;
    @Override
    public void addWashingServce(List<Washing_Service> washingServiceList) {

        washingRepository.saveAll(washingServiceList);
    }


}
