package com.games.armyBuilder.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.armyBuilder.objects.Army;
import com.games.armyBuilder.requests.ArmyRequest;

@RestController
@RequestMapping("/test")
public class TestController {
	
	private Army army = new Army();
	
	@GetMapping("/getArmy")
	public Army getArmy() {
		return army;
	}
	
	@PostMapping("/createArmy")
	public String createArmy(@RequestBody ArmyRequest armyRequest) {
		return "Army created";
	}

}
