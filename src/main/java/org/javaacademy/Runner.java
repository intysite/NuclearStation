package org.javaacademy;

import org.javaacademy.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        NuclearStation nuclearStation = context.getBean(NuclearStation.class);
        nuclearStation.start(3);
        System.out.println(nuclearStation.getTotalAmountOfEnergyGenerated());
    }
}