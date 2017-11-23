package entity;

import entity.Terning;

public class Kast {
	private int terningVærdi;

	Terning terning = new Terning();

	public void kastTerninger() {
		terning.kastTerning();
		terningVærdi = terning.getVærdi();
	}

	public int getTerningVærdi() {
		return terningVærdi;
	}
}
