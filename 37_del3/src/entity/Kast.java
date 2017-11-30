/**Klassen Kast er der udviklet metoder til oprettelse af terninger, 
 * samt metoder som samler summen afværdierne af terningerne som fås fra Terning-klassen.
 * 
 */
package entity;

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
