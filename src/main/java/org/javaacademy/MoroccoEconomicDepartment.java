package org.javaacademy;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
@Profile("morocco")
public class MoroccoEconomicDepartment extends EconomicDepartment {
    @Override
    public BigDecimal computeYearIncomes(long countElectricity) {
        BigDecimal baseRate = BigDecimal.valueOf(5);
        BigDecimal increasedRate = BigDecimal.valueOf(6);
        long fiveBillion = 5_000_000_000L;
        BigDecimal income;

        if (countElectricity <= fiveBillion) {
            income = baseRate.multiply(BigDecimal.valueOf(countElectricity));
        } else {
            long remainingKilowattHours = countElectricity - fiveBillion;
            income = baseRate.multiply(BigDecimal.valueOf(fiveBillion))
                    .add(increasedRate.multiply(BigDecimal.valueOf(remainingKilowattHours)));
        }

        return income;
    }
}
