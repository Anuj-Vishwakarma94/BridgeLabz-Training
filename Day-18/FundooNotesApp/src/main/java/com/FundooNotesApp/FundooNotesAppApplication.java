package com.FundooNotesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling   // Activates @Scheduled in ReminderScheduler
public class FundooNotesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FundooNotesAppApplication.class, args);
	}

}
