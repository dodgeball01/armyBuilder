package com.games.armyBuilder.objects;

import java.util.ArrayList;
import java.util.List;

public class Army {
	private List<Unit> units;
	private int totalPoints;
	private int currentPoints;
	private String name;
	
	public Army() {
		
	}
	
	public Army(String name, int totalPoints, int currentPoints) {
		this.totalPoints = totalPoints;
		this.currentPoints = currentPoints;
		this.name = name;
		this.units = new ArrayList<>();
	}
	
	public List<Unit> getUnits() {
		return units;
	}
	
	public void addUnit(String unitName, int level, int model, List<String> abilities, int unitCount) {
		Unit unit = new Unit(unitName, level, model, abilities, unitCount);
		this.units.add(unit);
	}
	
	public int removeUnit(String unitName, int model) {
		int unitIndex = -1;
		int unitCount = 0;
		
		for (Unit unit : units) {
			if (unit.getName().equalsIgnoreCase(unitName) && unit.getModel() == model) {
				unitIndex = units.indexOf(unit);
				unitCount = unit.getCount();
			}	
		}
		
		if (unitIndex > -1) {
			units.remove(unitIndex);
		}
		
		return unitCount;
	}
	
	public void setTotalPoints(int points) {
		this.totalPoints = points;
	}
	
	public int getTotalPoints() {
		return totalPoints;
	}
	
	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}
	
	public int getCurrentPoints() {
		return currentPoints;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
