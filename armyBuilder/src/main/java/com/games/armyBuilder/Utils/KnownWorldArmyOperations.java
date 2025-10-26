package com.games.armyBuilder.Utils;

import java.util.List;

import com.games.armyBuilder.objects.Army;
import com.games.armyBuilder.objects.KnownWorldArmies.Units;
import com.games.armyBuilder.requests.ArmyRequest;
import com.games.armyBuilder.requests.UnitRequest;
import com.games.armyBuilder.requests.UpdateArmyRequest;

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
			int unitCount = armyUnit.getCount();
			
			int level = levelFromUnitAndModel(unitName, unitModel);
			List<String> abilities = abilitiesFromUnitAndModel(unitName, unitModel);
			int cost = costFromUnitAndModel(unitName, unitModel);
			
			currentPoints -= (unitCount * cost);
			//TODO: create exception to throw if currentPoints < 0
			
			army.addUnit(unitName, level, unitModel, abilities, unitCount);
		}
		
		army.setCurrentPoints(currentPoints);
		
		return army;
	}
	
	public Army updateArmy(UpdateArmyRequest updateArmyRequst, Army army) {
		List<UnitRequest> armyUnits = updateArmyRequst.getUnits();
		
		for (UnitRequest armyUnit : armyUnits) {
			String unitName = armyUnit.getName();
			int unitModel = armyUnit.getModel();
			int unitCount = armyUnit.getCount();
//			TODO: might move logic to find unit in unitList from army.removeUnit
//			TODO: add logic to see if unit already exists and then code for adding or updating unitlist
			if (unitCount == 0) {
				army = removeUnit(unitName, unitModel, army);
			} else {
				army = addUnit(unitName, unitModel, army, unitCount);
			}
		}
		
		return army;
	}
	
	private Army removeUnit(String unitName, int model, Army army) {
		int currentPoints = army.getCurrentPoints();
		
		int cost = costFromUnitAndModel(unitName, model);
		
		int unitCount = army.removeUnit(unitName, model);
//		TODO: may have to set something if unit is not found, above unitCount will come back as zero
		army.setCurrentPoints(currentPoints += (unitCount * cost));
		
		return army;
	}
	
	private Army addUnit(String unitName, int model, Army army, int count) {
		int currentPoints = army.getCurrentPoints();
		
		int level = levelFromUnitAndModel(unitName, model);
		List<String> abilities = abilitiesFromUnitAndModel(unitName, model);
		int cost = costFromUnitAndModel(unitName, model);
		
		currentPoints -= (count * cost);
		//TODO: create exception to throw if currentPoints < 0
		
		army.addUnit(unitName, level, model, abilities, count);
		army.setCurrentPoints(currentPoints);
		
		return army;
	}
	
}
