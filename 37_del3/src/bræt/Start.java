package bræt;

public class Start extends AbstractFelter {

	private final int startbonus = 2;

	public Start (int feltnr) {
		super(feltnr); 
	}

	@Override
	public String toString(){
		return "Du har passeret start, og modtager en startbonus på " + startbonus + "M";
	}
	
	public int getStartBonus(){
		return startbonus;
	}
}
