package com.hexaware.cricketteammanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.cricketteammanagement.dto.PlayerDto;
import com.hexaware.cricketteammanagement.entity.Player;
import com.hexaware.cricketteammanagement.exception.PlayerNotFoundException;
import com.hexaware.cricketteammanagement.repository.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerServiceImp implements IPlayerService{

	
	  @Autowired
	 PlayerRepository playerRepository;
	  
	  public Player createPlayer(PlayerDto playerDto) {
		    Player player = new Player();
		    player.setPlayerName(playerDto.getPlayerName());
		    player.setJerseyNumber(playerDto.getJerseyNumber());
		    player.setRole(playerDto.getRole());
		    player.setTotalMatches(playerDto.getTotalMatches());
		    player.setTeamName(playerDto.getTeamName());
		    player.setCountryName(playerDto.getCountryName());
		    player.setDescription(playerDto.getDescription());

		    return playerRepository.save(player);  
		}
	  
	@Override
	public Player updatePlayer(int playerId, PlayerDto playerDto) {
	    Player exPlayer = playerRepository.findById(playerId).orElseThrow(() -> 
	    new PlayerNotFoundException("Player not found with id: " + playerId));

	    exPlayer.setPlayerName(playerDto.getPlayerName());
	    exPlayer.setJerseyNumber(playerDto.getJerseyNumber());
	    exPlayer.setRole(playerDto.getRole());
	    exPlayer.setTotalMatches(playerDto.getTotalMatches());
	    exPlayer.setTeamName(playerDto.getTeamName());
	    exPlayer.setCountryName(playerDto.getCountryName());
	    exPlayer.setDescription(playerDto.getDescription());

	    return playerRepository.save(exPlayer);
	}
	@Override
	public String deletePlayer(int playerId) {
	    Player existingPlayer = playerRepository.findById(playerId).orElseThrow(() ->
	    new PlayerNotFoundException("Player not found with id: " + playerId));
	    playerRepository.deleteById(playerId);
	    return "Player with ID " + playerId + " deleted";
	}

	@Override
	public List<Player> getAllPlayers() {
	    return playerRepository.findAll();
	}


	@Override
	public Player getPlayerById(int playerId) {	
	    return playerRepository.findById(playerId).orElseThrow(() ->
	    new PlayerNotFoundException("Player not found with id: " + playerId));
	}

	
	
}
