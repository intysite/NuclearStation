package org.javaacademy;

import org.javaacademy.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.exceptions.ReactorWorkException;
import org.springframework.stereotype.Component;

@Component
public class ReactorDepartment {
    private boolean isWorking;
    private int startsCount = 0;

    public long run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWorking) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        isWorking = !isWorking;
        startsCount++;
        if(startsCount % 100 == 0) {
            throw new NuclearFuelIsEmptyException("Топливо закончилось");
        }
        return 10_000_000L;
    }

    public void stop() {
        if (!isWorking) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWorking = !isWorking;
    }
}