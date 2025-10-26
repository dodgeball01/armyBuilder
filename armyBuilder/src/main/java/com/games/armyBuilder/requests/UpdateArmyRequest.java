package com.games.armyBuilder.requests;

import java.util.List;

public class UpdateArmyRequest {
	private List<UpdateUnitRequest> units;
	
	public UpdateArmyRequest() {
		
	}

	public List<UpdateUnitRequest> getUnits() {
		return units;
	}

	public void setUnits(List<UpdateUnitRequest> units) {
		this.units = units;
	}

}
