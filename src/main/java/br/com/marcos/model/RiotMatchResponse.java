package br.com.marcos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RiotMatchResponse {

	
	private String NameChampion;
	
	@JsonProperty("championId")
	private int championId;
	
	@JsonProperty("championPoints")
	private String championPoints;

	@JsonProperty("championLevel")
	private String championLevel;

	
	
	

	public RiotMatchResponse(String nameChampion, int championId, String championPoints, String championLevel) {
		NameChampion = nameChampion;
		this.championId = championId;
		this.championPoints = championPoints;
		this.championLevel = championLevel;
	}



	public RiotMatchResponse() {
		
	}



	public String getNameChampion() {
		return NameChampion;
	}

	public void setNameChampion(String nameChampion) {
		NameChampion = nameChampion;
	}

	


	public int getChampionId() {
		return championId;
	}



	public void setChampionId(int championId) {
		this.championId = championId;
	}



	public String getChampionPoints() {
		return championPoints;
	}

	public void setChampionPoints(String championPoints) {
		this.championPoints = championPoints;
	}

	public String getChampionLevel() {
		return championLevel;
	}

	public void setChampionLevel(String championLevel) {
		this.championLevel = championLevel;
	}
	


	
	
	
	
}
