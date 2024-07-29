package br.com.marcos.service;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.marcos.model.RiotMatchResponse;
import br.com.marcos.model.RiotResponse;

@Service
public class LastMatchService {
	

	
	private RestTemplate rest;
	private Map<Integer, String> mapChampionId = new HashMap<>();
	private final String apiKey ="RGAPI-444f8d71-b405-4db1-a7b2-5b085c8ecb04";
	
	
	

	
	
	public LastMatchService(RestTemplate rest, Map<Integer, String> mapChampionId) {
		this.rest = rest;
		this.mapChampionId = mapChampionId;
	}





	public 	RiotResponse getData(String name, String tag) {
		
		String url = "https://americas.api.riotgames.com/riot/account/v1/accounts/by-riot-id/"+name+"/"+tag+"?api_key="+apiKey;
		ResponseEntity<RiotResponse> responseEntity = rest.getForEntity(url, RiotResponse.class);
		RiotResponse response = responseEntity.getBody();
		return response;
	}
	
	public 	List<RiotMatchResponse> getLastMatch(String name,String tag,int cont) {
		getKeyChampion();
		RiotResponse riot = getData(name,tag);
		String puuid = riot.getPuuid();
		Gson gson = new Gson();
		String url = "https://br1.api.riotgames.com/lol/champion-mastery/v4/champion-masteries/by-puuid/"+ puuid +"/top?count="+ cont +"&api_key="+apiKey;
		ResponseEntity<List<RiotMatchResponse>> responseEntity = rest.exchange(url, HttpMethod.GET,null,new ParameterizedTypeReference<List<RiotMatchResponse>>() {
		});
		List<RiotMatchResponse> response = responseEntity.getBody();
		
		for(int i = 0 ; i < response.size(); i ++) {
			 if(mapChampionId.containsKey(response.get(i).getChampionId())){
				 response.get(i).setNameChampion(mapChampionId.get(response.get(i).getChampionId()));;
			 }
		}
		return response;
	}
	
	
	public Map<Integer, String> getKeyChampion() {
		String url = "src/main/java/jsons/champion.json";
		Gson gson = new Gson();
		   try (FileReader reader = new FileReader(url)) {
	            // Ler o JSON completo como JsonObject
	            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);

	            // Acessar o objeto "data" que contém os campeões
	            JsonObject dataObject = jsonObject.getAsJsonObject("data");

	            // Iterar sobre as entradas no objeto "data"
	            for (Map.Entry<String, JsonElement> entry : dataObject.entrySet()) {
	                JsonObject champion = entry.getValue().getAsJsonObject();
	                Integer key = champion.get("key").getAsInt();
	                String name = champion.get("name").getAsString();
	                mapChampionId.put(key, name);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	      
		
		return mapChampionId;
	}
	

	
	
}
