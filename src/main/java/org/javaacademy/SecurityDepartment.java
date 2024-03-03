package org.javaacademy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SecurityDepartment {
    private int accidentCountPeriod = 0;
    private final NuclearStation nuclearStation;

    @Lazy
    public SecurityDepartment(NuclearStation nuclearStation) {
        this.nuclearStation = nuclearStation;
    }

    public void addAccident() {
        accidentCountPeriod++;
    }

    public int getCountAccidents() {
        return accidentCountPeriod;
    }

    public void reset() {
        nuclearStation.incrementAccident(accidentCountPeriod);
        accidentCountPeriod = 0;
    }
}
