package bræt;

import entity.Spiller;

public abstract class  AbstractFelter {

	private int feltnr;


	public AbstractFelter(int feltnr){
		this.feltnr = feltnr;
	}
	
	public abstract String toString();
	
	//public abstract void opretFelt();
	
	public abstract void landOnField(Spiller spiller);
	
	
	
	
}
