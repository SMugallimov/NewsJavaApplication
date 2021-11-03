package com.synergyproject.newsjavaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NewsJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsJavaApplication.class, args);
	}
}