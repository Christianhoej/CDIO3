package bræt;

public abstract class  AbstractFelter {


	private String feltnavn;
	private int feltnr;


	public AbstractFelter(int feltnr){
		this.feltnr = feltnr;
		opretFelt();
	}
	
	public String toString(){
		String result = "Du har landet på " + feltnavn + ", vent til din næste tur.";
		return result;
	}
	
	private abstract void opretFelt();
	
	
	
	
	
}
