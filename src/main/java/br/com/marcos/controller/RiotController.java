package br.com.marcos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Producer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcos.model.RiotMatchResponse;
import br.com.marcos.model.RiotResponse;
import br.com.marcos.service.LastMatchService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class RiotController {

	
	private LastMatchService service;
	
	public RiotController(LastMatchService service) {
		this.service = service;
	}
	
	@GetMapping(value ="/champions",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RiotMatchResponse>> getMethodName(@RequestParam String name , @RequestParam String tag,
			@RequestParam int quant) {
		List<RiotMatchResponse> data = service.getLastMatch(name,tag,quant);
		return ResponseEntity.ok(data);
	}
	
}
