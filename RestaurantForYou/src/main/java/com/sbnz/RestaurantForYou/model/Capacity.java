package com.sbnz.RestaurantForYou.model;

public enum Capacity {

	SMALL, MEDIUM, LARGE;

	public static Capacity StringToEnum(String string) {
		
		String s = string.toUpperCase();
		if (s.equals("SMALL")) {
			return Capacity.SMALL;
		} else if (s.equals("MEDIUM")) {
			return Capacity.MEDIUM;
		} else if (s.equals("LARGE")) {
			return Capacity.LARGE;
		} else {
			return null;
		}
	}
}
