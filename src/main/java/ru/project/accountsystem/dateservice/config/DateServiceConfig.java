package ru.project.accountsystem.dateservice.config;

import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.project.accountsystem.services.DateService;
import ru.project.accountsystem.services.impl.JodaDateService;

/**
 * Created by Admin on 05.05.2019.
 */
@Configuration
public class DateServiceConfig {

    @Bean
    DateService dateService() {
       return new JodaDateService(defaultTimeZone());
    }

    @Bean
    DateTimeZone defaultTimeZone() {
        return DateTimeZone.UTC;
    }
}
