package com.sbnz.RestaurantForYou.model;

public enum Music {

	CLASSIC, FOREIGN, LIVE, POP, JAZZ, OLD_TOWN, TAMBURITZA;
	
	public static Music StringToEnum(String string){
		String s = string.toUpperCase();
		if (s.equals("CLASSIC")) {
			return Music.CLASSIC;
		} else if (s.equals("FOREIGN")) {
			return Music.FOREIGN;
		} else if (s.equals("LIVE")) {
			return Music.LIVE;
		}  else if (s.equals("POP")) {
			return Music.POP;
		}  else if (s.equals("JAZZ")) {
			return Music.JAZZ;
		}   else if (s.equals("OLD TOWN)")) {
			return Music.OLD_TOWN;
		}   else if (s.equals("TAMBURITZA")) {
			return Music.TAMBURITZA;
		} else {
			return null;
		}
	}
}
