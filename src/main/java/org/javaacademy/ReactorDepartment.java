package org.javaacademy;

import org.javaacademy.exceptions.NuclearFuelIsEmptyException;
import org.javaacademy.exceptions.ReactorWorkException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReactorDepartment {
    private boolean isWorking;
    private int startsCount = 0;
    private final SecurityDepartment securityDepartment;

    @Autowired
    public ReactorDepartment(SecurityDepartment securityDepartment) {
        this.securityDepartment = securityDepartment;
    }

    public long run() throws ReactorWorkException, NuclearFuelIsEmptyException {
        if (isWorking) {
            throw new ReactorWorkException("Реактор уже работает");
        }
        startsCount++;
        if(startsCount == 100) {
            startsCount = 0;
            securityDepartment.addAccident();
            throw new NuclearFuelIsEmptyException("Топливо закончилось");
        }
        isWorking = !isWorking;
        return 10_000_000L;
    }

    public void stop() {
        if (!isWorking) {
            throw new ReactorWorkException("Реактор уже выключен");
        }
        isWorking = !isWorking;
    }
}