package com.example.crochettracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CrochetTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrochetTrackerApplication.class, args);
	}

}
