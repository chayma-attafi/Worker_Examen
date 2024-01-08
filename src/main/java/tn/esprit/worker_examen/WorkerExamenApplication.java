package tn.esprit.worker_examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class WorkerExamenApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkerExamenApplication.class, args);
    }

}
