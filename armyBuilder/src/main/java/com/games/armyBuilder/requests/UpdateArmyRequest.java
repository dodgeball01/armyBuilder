package com.games.armyBuilder.requests;

import java.util.List;

public class UpdateArmyRequest {
	private List<UnitRequest> units;
	
	public UpdateArmyRequest() {
		
	}

	public List<UnitRequest> getUnits() {
		return units;
	}

	public void setUnits(List<UnitRequest> units) {
		this.units = units;
	}

}
