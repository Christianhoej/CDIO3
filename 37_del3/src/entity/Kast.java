package entity;

public class Kast {
	private int terningVærdi;

	Terning terning = new Terning();

	public void kastTerning() {
		terning.kastTerning();
		terningVærdi = terning.getVærdi();
	}

	public int getTerningVærdi() {
		return terningVærdi;
	}
}
