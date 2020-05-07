package com.sbnz.RestaurantForYou.model;

public enum Ambience {

	TRADITIONAL, HOMLY, CLASSIC, MODERN, ARTISTIC, CREATIVE;

	public static Ambience StringToEnum(String string) {
		String s = string.toUpperCase();
		if (s.equals("TRADITIONAL")) {
			return Ambience.TRADITIONAL;
		} else if (s.equals("HOMLY")) {
			return Ambience.HOMLY;
		} else if (s.equals("CLASSIC")) {
			return Ambience.CLASSIC;
		} else if (s.equals("MODERN")) {
			return Ambience.MODERN;
		} else if (s.equals("ARTISTIC")) {
			return Ambience.ARTISTIC;
		} else if (s.equals("CREATIVE")) {
			return Ambience.CREATIVE;
		} else {
			return null;
		}
	}

}
