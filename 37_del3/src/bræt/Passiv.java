package bræt;

public class Passiv extends AbstractFelter{
	private String feltNavn;

	public Passiv (int feltnr) {
		super(feltnr);
		switch(feltnr){
		case 6: feltNavn = "på besøg"; break;
		case 12: feltNavn = "gratis parkering"; break;
		}
	}

	@Override
	public String toString(){
		if(feltNavn.equals("på besøg"))
			return "Du er bare " + feltNavn;
		else
			return feltNavn + ", du behøver ikke gøre noget, bare snup dig en pause";
	}
}
