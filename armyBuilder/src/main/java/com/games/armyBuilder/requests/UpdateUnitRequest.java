package com.games.armyBuilder.requests;

public class UpdateUnitRequest extends UnitRequest {
	
	private String action;

	public UpdateUnitRequest(String name, int model, String action) {
		super(name, model);
		this.setAction(action);
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

}
