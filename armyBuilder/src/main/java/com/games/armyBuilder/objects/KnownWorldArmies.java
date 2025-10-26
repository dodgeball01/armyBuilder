package com.games.armyBuilder.objects;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum KnownWorldArmies {
	DRAGON_BLESSED_KNIGHTS("Dragon-blessed Knights"),
	THE_FREE_KINGDOMS("The Free Kingdoms"),
	WILDLANDERS("Wildlanders"),
	CORRUPTED("Corrupted"),
	UNDERWORLD("Underworld");
	
	private String armyName;
	
	private KnownWorldArmies(String armyName) {
		this.armyName = armyName;
	}

	public String getArmyName() {
		return armyName;
	}

	public void setArmyName(String armyName) {
		this.armyName = armyName;
	}
	
	public static KnownWorldArmies fromArmyName(String text) {
		for (KnownWorldArmies army : KnownWorldArmies.values()) {
			if (army.armyName.equalsIgnoreCase(text)) {
				return army;
			}
		}
		throw new IllegalArgumentException("No constant with text " + text + " found");
	}
	
	public enum Units {
		
		KNIGHT_COMMANDER("Knight Commander", 5, Arrays.asList("Blessed Armor", "Swords", "Reinforcements")){
			{
				modelCosts.put(1, 75);
			}
		},
		KNIGHTS("Knights", 3, Arrays.asList("Knights Armor", "Hammers", "Reinforcements")){
			{
				modelCosts.put(1, 56);
				modelCosts.put(5, 108);
				modelCosts.put(10, 173);
			}
		},
		SHOCK_KNIGHTS("Shock Knights", 3, Arrays.asList("Knights Armor", "Hammers", "Reinforcements", "Short Shot")){
			{
				modelCosts.put(1, 98);
				modelCosts.put(5, 150);
				modelCosts.put(10, 215);
			}
		},
		VENERABLE_KNIGHTS("Venerable Knights", 4, Arrays.asList("Knights Armor", "Healing Circle", "Hammers", "Lightning Strike", "Reinforcements")){
			{
				modelCosts.put(1, 109);
				modelCosts.put(5, 181);
				modelCosts.put(10, 271);
			}
		},
		KNIGHT_CAVALRY("Knight Cavalry", 4, Arrays.asList("Knights Armor", "Mounted Movement", "Lightning Strike", "Swords")){
			{
				modelCosts.put(1, 86);
				modelCosts.put(3, 122);
			}
		},
		DRAGON_BLOODED_BEAST("Dragon Blooded Beast", 9, Arrays.asList("Knights Armor", "Healing Circle", "Hammers", "Lightning Strike", "Reinforcements")){
			{
				modelCosts.put(1, 186);
			}
		};
		 
		private String name;
		private int level;
		private List<String> abilities;
		protected final Map<Integer, Integer> modelCosts;
		
		private Units(String name, int level, List<String> abilities) {
			this.name = name;
			this.level = level;
			this.abilities = abilities;
			this.modelCosts = new HashMap<>();
		}
		
		public String getName() {
			return name;
		}
		
		public int getLevel() {
			return level;
		}
		
		public List<String> getAbilities() {
			return abilities;
		}
		
		public Map<Integer, Integer> getModelCosts() {
			return modelCosts;
		}
		
		public int getCost(int numberOfModels) {
			return modelCosts.getOrDefault(numberOfModels, null);
		}
		
		public static Units fromName(String text) {
	        for (Units unit : Units.values()) {
	            if (unit.name.equalsIgnoreCase(text)) {
	                return unit;
	            }
	        }
	        throw new IllegalArgumentException("No constant with text " + text + " found");
	    }
	}

}
