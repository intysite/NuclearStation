package org.javaacademy;

import org.javaacademy.config.Config;
import org.javaacademy.exceptions.NuclearStation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ReactorDepartment reactorDepartment = (ReactorDepartment) context.getBean("reactorDepartment");
        NuclearStation nuclearStation = (NuclearStation) context.getBean("nuclearStation");
        nuclearStation.start(3);
        System.out.println(nuclearStation.getTotalAmountOfEnergyGenerated());
    }
}