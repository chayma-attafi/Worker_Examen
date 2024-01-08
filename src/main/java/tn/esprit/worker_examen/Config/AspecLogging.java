package tn.esprit.worker_examen.Config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AspecLogging {
    @After("execution(* tn.esprit.worker_examen.Service.*.addVehicleReservationAndAffectToWashing(..))")
    public void logMethodExit(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Waiting for a worker ! : " + name );
    }
}
