package com.hexaware.cricketteammanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.cricketteammanagement.dto.PlayerDto;
import com.hexaware.cricketteammanagement.entity.Player;
import com.hexaware.cricketteammanagement.service.IPlayerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/players")
public class PlayerRestController {

    @Autowired
    private IPlayerService playerService;

    @GetMapping("/getall")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/getplayerbyId/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int playerId) {
        return ResponseEntity.ok(playerService.getPlayerById(playerId));
    }

    @PostMapping("/addplayer")
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody PlayerDto playerDto) {
        Player savedPlayer = playerService.createPlayer(playerDto);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{playerId}")
    public Player updatePlayer(@PathVariable int playerId,@Valid @RequestBody PlayerDto playerDto) {
        return playerService.updatePlayer(playerId, playerDto);
    }

    @DeleteMapping("delete/{playerId}")
    public String deletePlayer(@PathVariable int playerId) {
        return playerService.deletePlayer(playerId);
    }
    
}