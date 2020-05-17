package com.sbnz.RestaurantForYou.model;

public enum Ambience {

	TRADITIONAL, PEACEFUL, RELAXED, MODERN, LUXURIOUS, CREATIVE;

	public static Ambience StringToEnum(String string) {
		String s = string.toUpperCase();
		if (s.equals("TRADITIONAL")) {
			return Ambience.TRADITIONAL;
		} else if (s.equals("PEACEFUL")) {
			return Ambience.PEACEFUL;
		} else if (s.equals("RELAXED")) {
			return Ambience.RELAXED;
		} else if (s.equals("MODERN")) {
			return Ambience.MODERN;
		} else if (s.equals("LUXURIOUS")) {
			return Ambience.LUXURIOUS;
		} else if (s.equals("CREATIVE")) {
			return Ambience.CREATIVE;
		} else {
			return null;
		}
	}

}
