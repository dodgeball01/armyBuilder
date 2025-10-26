package com.games.armyBuilder.Utils;

import java.util.List;

import com.games.armyBuilder.objects.Army;
import com.games.armyBuilder.objects.KnownWorldArmies.Units;
import com.games.armyBuilder.requests.ArmyRequest;
import com.games.armyBuilder.requests.UnitRequest;
import com.games.armyBuilder.requests.UpdateArmyRequest;
import com.games.armyBuilder.requests.UpdateUnitRequest;

public class KnownWorldArmyOperations {
	Units knownUnits;
	
	public KnownWorldArmyOperations() {
		
	}
	
	private int costFromUnitAndModel(String unitName, int model) {
		knownUnits = Units.fromName(unitName);
		return knownUnits.getCost(model);
	}
	
	private List<String> abilitiesFromUnitAndModel(String unitName, int model) {
		knownUnits = Units.fromName(unitName);
		return knownUnits.getAbilities();
	}
	
	private int levelFromUnitAndModel(String unitName, int model) {
		knownUnits = Units.fromName(unitName);
		return knownUnits.getLevel();
	}
	
	public Army createNewArmy(ArmyRequest armyRequest) {
		String armyName = armyRequest.getArmyName();
		int totalPoints = armyRequest.getTotalPoints();
		int currentPoints = armyRequest.getCurrentPoints();
		List<UnitRequest> armyUnits = armyRequest.getUnits();
		
		Army army = new Army(armyName, totalPoints, currentPoints);
		
		for (UnitRequest armyUnit : armyUnits) {
			String unitName = armyUnit.getName();
			int unitModel = armyUnit.getModel();
			
			int level = levelFromUnitAndModel(unitName, unitModel);
			List<String> abilities = abilitiesFromUnitAndModel(unitName, unitModel);
			int cost = costFromUnitAndModel(unitName, unitModel);
			
			currentPoints -= cost;
			//TODO: create exception to throw if currentPoints < 0
			
			army.addUnit(unitName, level, unitModel, abilities);
		}
		
		army.setCurrentPoints(currentPoints);
		
		return army;
	}
	
	public Army updateArmy(UpdateArmyRequest updateArmyRequst, Army army) {
		List<UpdateUnitRequest> armyUnits = updateArmyRequst.getUnits();
		
		for (UpdateUnitRequest armyUnit : armyUnits) {
			String unitName = armyUnit.getName();
			int unitModel = armyUnit.getModel();
			String unitAction = armyUnit.getAction();
			
			if (unitAction.equalsIgnoreCase("Remove")) {
				army = removeUnit(unitName, unitModel, army);
			} else {
				army = addUnit(unitName, unitModel, army);
			}
		}
		
		return army;
	}
	
	private Army removeUnit(String unitName, int model, Army army) {
		int currentPoints = army.getCurrentPoints();
		
		int cost = costFromUnitAndModel(unitName, model);
		
		army.removeUnit(unitName, model);
		army.setCurrentPoints(currentPoints += cost);
		
		return army;
	}
	
	private Army addUnit(String unitName, int model, Army army) {
		int currentPoints = army.getCurrentPoints();
		
		int level = levelFromUnitAndModel(unitName, model);
		List<String> abilities = abilitiesFromUnitAndModel(unitName, model);
		int cost = costFromUnitAndModel(unitName, model);
		
		currentPoints -= cost;
		//TODO: create exception to throw if currentPoints < 0
		
		army.addUnit(unitName, level, model, abilities);
		army.setCurrentPoints(currentPoints);
		
		return army;
	}
	
}
