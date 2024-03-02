package org.javaacademy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.stream.LongStream;

@Component
@Profile("france")
public class FranceEconomicDepartment extends EconomicDepartment {
    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        BigDecimal baseRate = BigDecimal.valueOf(0.5);
        long billion = 1_000_000_000;

        BigDecimal incomeForBillions = LongStream.range(0, countElectricity / billion)
                .mapToObj(i -> BigDecimal.valueOf(billion)
                        .multiply(baseRate.multiply(BigDecimal.valueOf(Math.pow(0.99, i)))))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal incomeForRemaining = BigDecimal.valueOf(countElectricity % billion)
                .multiply(baseRate.multiply(BigDecimal.valueOf(Math.pow(0.99, countElectricity / billion))));

        return incomeForBillions.add(incomeForRemaining);
    }
}