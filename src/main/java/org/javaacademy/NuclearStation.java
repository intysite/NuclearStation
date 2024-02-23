package org.javaacademy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Component
public class NuclearStation {
    private final ReactorDepartment reactorDepartment;
    private long totalAmountOfEnergyGenerated = 0;
    private int accidentCountAllTime = 0;
    private final SecurityDepartment securityDepartment;

    @Lazy
    public NuclearStation(ReactorDepartment reactorDepartment, SecurityDepartment securityDepartment) {
        this.reactorDepartment = reactorDepartment;
        this.securityDepartment = securityDepartment;
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
        System.out.printf("Количество инцидентов за год: %d\n", securityDepartment.getCountAccidents());
        securityDepartment.reset();
    }

    public void start(int year) {
        IntStream.range(0, year)
                .forEach(i -> {
                    this.startYear();
                    System.out.printf("Количество инцидентов за всю работу станции: %d\n", accidentCountAllTime);
                });
    }

    public void incrementAccident(int count) {
        accidentCountAllTime += count;
    }

    public long getTotalAmountOfEnergyGenerated() {
        return totalAmountOfEnergyGenerated;
    }
}