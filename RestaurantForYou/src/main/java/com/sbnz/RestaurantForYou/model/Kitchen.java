package com.sbnz.RestaurantForYou.model;

public enum Kitchen {

	LOCAL, ITALIAN, CHINESE, HEALTHY, FISH;
	
	public static Kitchen StringToEnum(String string){
		String s = string.toUpperCase();
		if (s.equals("LOCAL")) {
			return Kitchen.LOCAL;
		} else if (s.equals("ITALIAN")) {
			return Kitchen.ITALIAN;
		} else if (s.equals("CHINESE")) {
			return Kitchen.CHINESE;
		} else if (s.equals("HEALTHY")) {
			return Kitchen.HEALTHY;
		} else if (s.equals("FISH")) {
			return Kitchen.FISH;
		} else {
			return null;
		}
	}
	
	
}