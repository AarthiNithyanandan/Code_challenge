package com.hexaware.cricketteammanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.hexaware.cricketteammanagement")
public class CricketTeamManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CricketTeamManagementApplication.class, args);
	}
	

}
