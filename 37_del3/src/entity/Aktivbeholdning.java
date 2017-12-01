/**Klassen Aktivbeholdning indeholder metoder til at oprette en beholdning for hver spiller
 * I klassen findes metoder til både spillernes likvide midler, samt spillernes beholdning af aktiver.
 */
package entity;

public class Aktivbeholdning {

	private int anlægsAktiver = 0;
	private int likvideMidler = 0;
	private int[]skøder = new int[16];

	/**
	 * Konstruktør til Aktivbeholdning
	 * @param likvideMidler Spillerens likvide midler
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
	 * (Ved passering af start, og ved indbetalt husleje)
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
		for(int i = 0; i<skøder.length; i++) {
			if (skøder[i] == feltNr) {
				skøder[i] = 0;
				break; 
			}
		}
	}
	/**
	 * Metode til at afgive skøder fra bestemte felter
	 * @param feltNr
	 */
	public void sælgSkøde(int feltNr) {

		for(int i = 0; i<skøder.length; i++) {
			if (skøder[i] == feltNr) {
				skøder[i] = 0;
				break; 
			}
		}
	}
	
	public int[] getSkøder(){
		return skøder;
	}

}