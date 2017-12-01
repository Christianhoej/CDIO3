/**
 * Klassen taber tester for hver runde om en spiller har opnået en beholdning på mindre end 0.
 */
package nogetAndet;

public class Taber {
	private boolean taber;
	private int taberGrænse = 0;

	public void setTaber(boolean taber) {
		this.taber = taber;
	}
	
	public boolean isTaber() {
		return taber;
	}
	
	/**
	 * harTabt tester om spillerens beholdningsværdi er mindre end den angivne grænse. 
	 * @param beholdningsværdi Spillerens beholdnigsværdi.
	 */
	
	public void harTabt(int beholdningsværdi) {
		if(taberGrænse>beholdningsværdi)
			setTaber(true);
		else
			setTaber(false);
	}
}
