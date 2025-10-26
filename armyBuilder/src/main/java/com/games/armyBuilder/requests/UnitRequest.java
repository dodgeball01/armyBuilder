package com.games.armyBuilder.requests;

public class UnitRequest {
	private String name;
	private int model;
	
	public UnitRequest(String name, int model) {
		this.name = name;
		this.model = model;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setModel(int model) {
		this.model = model;
	}
	
	public int getModel() {
		return model;
	}

}
