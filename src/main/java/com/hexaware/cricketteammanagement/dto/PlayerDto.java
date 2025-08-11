package com.hexaware.cricketteammanagement.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
	 @NotBlank(message = "Player Name is required")
	    private String playerName;

	    @NotNull(message = "Jersey Number is required")
	    @Min(value = 1, message = "Jersey Number must be between 1 and 99")
	    @Max(value = 99)
	    private int jerseyNumber;

	    @NotBlank(message = "Role is required")
	    @Pattern(regexp = "Batsman|Bowler|Keeper|All Rounder", message = "Role must be one among them")
	    private String role;

	    @Min(value = 0, message = "Total Matches must be zero or positive")
	    private int totalMatches;

	    @NotBlank(message = "Team Name is required")
	    private String teamName;

	    @NotBlank(message = "CountryName is required")
	    private String countryName;

	    @Size(max = 500, message = "Description max length is 500 characters")
	    private String description;
	
}
