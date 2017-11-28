package nogetAndet;

import entity.Terning;

public class Tur {
Terning terning = new Terning();
	public int brugTur() {
		terning.kastTerning();
		
		return terning.getVærdi();
	}

}
