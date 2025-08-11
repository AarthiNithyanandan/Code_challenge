package com.hexaware.cricketteammanagement.service;

import java.util.List;

import com.hexaware.cricketteammanagement.dto.PlayerDto;
import com.hexaware.cricketteammanagement.entity.Player;

public interface IPlayerService {

	Player createPlayer(PlayerDto playerDto);
	Player updatePlayer(int playerId, PlayerDto playerDto);
	String deletePlayer(int playerId);
	List<Player> getAllPlayers();
	Player getPlayerById(int playerId);
	
}
