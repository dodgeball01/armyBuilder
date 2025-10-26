package com.games.armyBuilder.objects;

import java.util.List;

public class Unit {
	private String name;
	private int level;
	private int model;
	private List<String> abilities;
	
	public Unit() {
		
	}
	
	public Unit(String name, int level, int model, List<String> abilities) {
		this.name = name;
		this.level = level;
		this.model = model;
		this.abilities = abilities;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setModel(int model) {
		this.model = model;
	}
	
	public int getModel() {
		return model;
	}
	
	public void setAbilities(List<String> abilities) {
		this.abilities = abilities;
	}
	
	public List<String> getAbilities() {
		return abilities;
	}

}
