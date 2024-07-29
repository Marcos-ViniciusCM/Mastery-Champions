package br.com.marcos.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RiotResponse {

	@JsonProperty("puuid")
	private String puuid;

	public RiotResponse(String puuid) {
		this.puuid = puuid;
	}

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public RiotResponse() {
	
	}
	
	
	
}
