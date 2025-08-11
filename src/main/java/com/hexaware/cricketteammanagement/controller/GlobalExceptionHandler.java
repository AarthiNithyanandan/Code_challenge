package com.hexaware.cricketteammanagement.controller;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hexaware.cricketteammanagement.exception.PlayerNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<String> handlePlayerNotFound(PlayerNotFoundException ex) {
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
