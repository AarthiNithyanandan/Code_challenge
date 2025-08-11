package com.hexaware.cricketteammanagement.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.cricketteammanagement.entity.Player;


public interface PlayerRepository extends JpaRepository<Player,Integer> {

	
	
}
