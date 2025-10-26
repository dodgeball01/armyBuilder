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
	
	public void addUnit(String unitName, int level, int model, List<String> abilities) {
		Unit unit = new Unit(unitName, level, model, abilities);
		this.units.add(unit);
	}
	
	public void removeUnit(String unitName, int model) {
		int unitIndex = -1;
		
		for (Unit unit : units) {
			if (unit.getName().equalsIgnoreCase(unitName) && unit.getModel() == model) {
				unitIndex = units.indexOf(unit);
			}	
		}
		
		if (unitIndex > -1) {
			units.remove(unitIndex);
		} 
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
