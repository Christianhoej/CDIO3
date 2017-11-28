package bræt;

import entity.Spiller;

public class Fængsel extends AbstractFelter {

	private boolean besøg;
	private final int kaution = -1;
	private int feltnr;

	//Konstruktør kan laves
	public Fængsel( int feltnr){
		super(feltnr);
	}

	@Override
	public String toString(){
		return "Du er blevet taget for at stjæle slik, og skal i fængsel";
	}
	
	public void setIFængsel(){
		Spiller.setPlacering(6);
	}
	
	public void betalKaution(){
		Spiller.opdater(kaution);
	}
	
	
}
