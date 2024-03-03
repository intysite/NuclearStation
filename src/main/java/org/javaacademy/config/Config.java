package org.javaacademy.config;

import org.javaacademy.CountryInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan("org.javaacademy")

public class Config {
    @Bean
    @Profile("france")
    public CountryInfo franceInfo() {
        return new CountryInfo("Франция", "Евро");
    }

    @Bean
    @Profile("morocco")
    public CountryInfo moroccoInfo() {
        return new CountryInfo("Марокко", "Дирхам");
    }
}
