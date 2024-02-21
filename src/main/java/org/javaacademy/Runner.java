package org.javaacademy;

import org.javaacademy.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ReactorDepartment reactorDepartment = (ReactorDepartment) context.getBean("reactorDepartment");
        try {
            long powerSum = reactorDepartment.run();
            reactorDepartment.stop();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}