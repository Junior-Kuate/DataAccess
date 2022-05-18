package com.example.demo.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(DataAccess repository) {
        return args -> {
            Student Junior = new Student(
                    64L,
                    "Junior",
                        "juniortagne310@gmail.com",
                        LocalDate.of(1998, Month.JANUARY, 22)
                    );

            repository.saveAll(
                    List.of(Junior)
            );
        };
    }

}
