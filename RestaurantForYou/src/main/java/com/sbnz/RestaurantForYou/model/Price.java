package com.sbnz.RestaurantForYou.model;

public enum Price {

	CHEAP, AFFORDABLE, EXPENSIVE;

	public static Price StringToEnum(String string) {
		String s = string.toUpperCase();
		if (s.equals("CHEAP")) {
			return Price.CHEAP;
		} else if (s.equals("AFFORDABLE")) {
			return Price.AFFORDABLE;
		} else if (s.equals("EXPENSIVE")) {
			return Price.EXPENSIVE;
		} else {
			return null;
		}
	}
}
