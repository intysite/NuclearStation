package org.javaacademy.exceptions;

import org.javaacademy.ReactorDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Component
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private long totalAmountOfEnergyGenerated = 0;

    @Autowired
    public NuclearStation(ReactorDepartment reactorDepartment) {
        this.reactorDepartment = reactorDepartment;
    }

    public void startYear() {
        System.out.println("Атомная станция начала работу");
        long sum = LongStream.range(0, 365)
                .map(i -> {
                    try {
                        long number = reactorDepartment.run();
                        reactorDepartment.stop();
                        totalAmountOfEnergyGenerated += number;
                        return number;
                    } catch (Exception e) {
                        System.out.println("Внимание! Происходят работы на атомной станции! Электричества нет!");
                        return 0L;
                    }
                })
                .sum();
        System.out.printf("Атомная станция закончила работу. За год выработано %d киловатт/часов\n", sum);
    }

    public void start(int year) {
        IntStream.range(0, year)
                .forEach(i -> this.startYear());
    }

    public long getTotalAmountOfEnergyGenerated() {
        return totalAmountOfEnergyGenerated;
    }
}