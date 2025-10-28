package com.games.armyBuilder.Utils;

import java.util.List;

import com.games.armyBuilder.objects.Army;
import com.games.armyBuilder.objects.KnownWorldArmies.Units;
import com.games.armyBuilder.objects.Unit;
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
			int newUnitCount = armyUnit.getCount();
			
			int cost = costFromUnitAndModel(unitName, unitModel);
			
			int[] unitIndexandCount = army.getUnitIndexAndCount(unitName, unitModel);
//			if unitIndex is not -1 then unit exists in army unit list
			int unitIndex = unitIndexandCount[0]; 
			int oldUnitCount = unitIndexandCount[1];
			
			if (unitIndex > -1 && newUnitCount == 0) {
				army = removeUnit(unitIndex, oldUnitCount, cost, army);
			} else if (unitIndex > -1 && newUnitCount > 0) {
				army = updateUnit(unitIndex, newUnitCount, oldUnitCount, cost, army);
			} else {
				army = addUnit(unitName, unitModel, newUnitCount, cost, army);
			}
		}
		
		return army;
	}
	
	private Army removeUnit(int unitIndex, int oldUnitCount, int cost, Army army) {
		int currentPoints = army.getCurrentPoints();
				
		army.removeUnit(unitIndex);
		army.setCurrentPoints(currentPoints += (oldUnitCount * cost));
		
		return army;
	}
	
	private Army addUnit(String unitName, int model, int count, int cost, Army army) {
		int currentPoints = army.getCurrentPoints();
		
		int level = levelFromUnitAndModel(unitName, model);
		List<String> abilities = abilitiesFromUnitAndModel(unitName, model);
		
		currentPoints -= (count * cost);
		
		army.addUnit(unitName, level, model, abilities, count);
		army.setCurrentPoints(currentPoints);
		
		return army;
	}
	
	private Army updateUnit(int unitIndex, int newUnitCount, int oldUnitCount, int cost, Army army) {
		int currentPoints = army.getCurrentPoints();
		
		Unit unit = army.getUnits().get(unitIndex);
		unit.setCount(newUnitCount);
		army.getUnits().set(unitIndex, unit);
		
		int countDifferance = oldUnitCount - newUnitCount;		
		currentPoints += (countDifferance * cost);
		
		army.setCurrentPoints(currentPoints);
		
		return army;
	}
}
