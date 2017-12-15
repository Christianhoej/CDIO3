package entity;

/**
 * Klassen Kast er kastes der med en terning
 *
 * @author Gruppe 37
 * 
 */

public class Kast {
	private int terningVærdi;

	Terning terning = new Terning();

	/**
	 * Metoden tager værdien for en terning, fra terningen klassen.
	 */
	public void kastTerning() {
		terning.kastTerning();
		terningVærdi = terning.getVærdi();
	}

	public int getTerningVærdi() {
		return terningVærdi;
	}
}
