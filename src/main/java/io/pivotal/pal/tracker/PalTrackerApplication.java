package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.data.InMemoryTimeEntryRepository;
import io.pivotal.pal.tracker.data.TimeEntryRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalTrackerApplication {
    @Bean
    TimeEntryRepository timeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    }

    public static void main(String[] args) {
        SpringApplication.run(PalTrackerApplication.class, args);
    }}


