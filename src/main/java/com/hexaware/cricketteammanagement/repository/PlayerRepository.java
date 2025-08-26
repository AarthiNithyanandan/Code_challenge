package com.hexaware.cricketteammanagement.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.cricketteammanagement.entity.Player;


public interface PlayerRepository extends JpaRepository<Player,Integer> {

//	 List<Player> searchByTeamName(String teamName);

	List<Player> findByTeamNameIgnoreCaseContaining(String teamName);
	
}
