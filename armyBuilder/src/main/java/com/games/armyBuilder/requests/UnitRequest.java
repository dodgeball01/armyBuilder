package com.games.armyBuilder.requests;

public class UnitRequest {
	private String name;
	private int model;
	private int count;
	
	public UnitRequest(String name, int model, int count) {
		this.name = name;
		this.model = model;
		this.count = count;
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
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}

}
