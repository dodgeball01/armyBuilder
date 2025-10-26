package com.games.armyBuilder.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.armyBuilder.Utils.KnownWorldArmyOperations;
import com.games.armyBuilder.objects.Army;
import com.games.armyBuilder.requests.ArmyRequest;
import com.games.armyBuilder.requests.UpdateArmyRequest;

@RestController
@RequestMapping("/KnownWorldBuilder")
public class KnownWorldBuilderController {
	
	KnownWorldArmyOperations createArmy = new KnownWorldArmyOperations();
	
	private Army army = new Army();
	
	@GetMapping("/getArmy")
	public Army getArmy() {
		return army;
	}
	
	@PostMapping("/createArmy")
	public Army createArmy(@RequestBody ArmyRequest armyRequest) {
		army = createArmy.createNewArmy(armyRequest);
		return army;
	}
	
	@PutMapping("/updateArmy")
	public Army updateArmy(@RequestBody UpdateArmyRequest updateArmyRequest) {
		army = createArmy.updateArmy(updateArmyRequest, army);
		return army;		
	}

}
