package com.games.armyBuilder.requests;

import java.util.List;

public class ArmyRequest {
	
	private int totalPoints;
	private int currentPoints;
	private String armyName;
	private List<UnitRequest> units;
	
	public ArmyRequest(int totalPoints, int currentPoints, String armyName, List<UnitRequest> units) {
		this.totalPoints = totalPoints;
		this.currentPoints = currentPoints;
		this.armyName = armyName;
		this.units = units;
	}
	
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
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
	
	public void setArmyName(String armyName) {
		this.armyName = armyName;
	}
	
	public String getArmyName() {
		return armyName;
	}
	
	public void setUnits(List<UnitRequest> units) {
		this.units = units;
	}
	
	public List<UnitRequest> getUnits() {
		return units;
	}

}
