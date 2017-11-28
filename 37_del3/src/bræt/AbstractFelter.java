package bræt;

public abstract class  AbstractFelter {


	private String feltnavn;
	private int feltnr;


	public AbstractFelter(int feltnr){
		this.feltnr = feltnr;
	}
	
	public abstract String toString();
	
	//public abstract void opretFelt();
	
	
	
	
	
}
