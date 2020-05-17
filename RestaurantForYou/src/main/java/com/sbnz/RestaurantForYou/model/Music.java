package com.sbnz.RestaurantForYou.model;

public enum Music {

	CLASSICAL, FOLK, POP, JAZZ, ROCK, TAMBURITZA;
	
	public static Music StringToEnum(String string){
		String s = string.toUpperCase();
		if (s.equals("CLASSICAL")) {
			return Music.CLASSICAL;
		} else if (s.equals("FOLK")) {
			return Music.FOLK;
		} else if (s.equals("ROCK")) {
			return Music.ROCK;
		}  else if (s.equals("POP")) {
			return Music.POP;
		}  else if (s.equals("JAZZ")) {
			return Music.JAZZ;
		}   else if (s.equals("TAMBURITZA")) {
			return Music.TAMBURITZA;
		} else {
			return null;
		}
	}
}
