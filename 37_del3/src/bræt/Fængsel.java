package bræt;

public class Fængsel extends Felter {

	private boolean besøg;
	private int kaution;

	//Konstruktør kan laves
	public Fængsel(String feltnavn, int feltnr, String billede, boolean besøg, int kaution){
		super(feltnavn, feltnr, billede);
	}

}
