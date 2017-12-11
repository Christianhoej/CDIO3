 
package entity;

/**
 * Klassen Aktivbeholdning indeholder metoder til at opdatere en spillers beholdning.
 * I klassen findes metoder til både spillernes likvide midler, samt spillernes beholdning af aktiver.
 * 
 * @author Gruppe 37
 *
 */
public class Aktivbeholdning {

	private int anlægsAktiver = 0;
	private int likvideMidler = 0;
	private int[]skøder = new int[24];

	/** 
	 * Konstruktør til Aktivbeholdning
	 * @param likvideMidler - Spillerens likvide midler
	 */
	public Aktivbeholdning(int likvideMidler) {
		this.likvideMidler = likvideMidler;

	}
	/**
	 * Tilføjer anlægs aktiver til spillerens beholdning
	 * (Bruges ved køb af ejendom)
	 * @param anlægsAktiver 
	 */
	// Måske overflødig? ligger den ikke i skøde?
	public void addAnlægsAktiver(int anlægsAktiver) {
		this.anlægsAktiver += anlægsAktiver;
	}

	public int getAnlægsAktiver() {
		return anlægsAktiver;
	}
	
	/**
	 * Tilføjer likvide midler til spillernes beholdning
	 * 
	 * @param likvideMidler
	 */
	public void addLikvideMidler(int likvideMidler) {
		this.likvideMidler += likvideMidler;
	}

	public int getLikvideMidler() {
		return likvideMidler;
	}
	
	/**
	 * Metode til at tilegne skøder til bestemte felter
	 * @param feltNr Angiver hvilket felt på brættet
	 */
	public void købSkøde(int feltNr) {
		skøder[feltNr] = feltNr;
	}
	
	/**
	 * Metode til at afgive skøder fra bestemte felter
	 * @param feltNr
	 */
	public int[] getSkøder(){
		return skøder;
	}

}