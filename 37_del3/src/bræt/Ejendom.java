package bræt;

import entity.Spiller;
import gui_fields.GUI_Field;
import gui_fields.GUI_Ownable;
import gui_main.GUI;


/**
 * Klassen Ejendom nedarver fra AbstractFelter.
 * Klassen står for oprettelsen af ejendomsfelterne samt deres individuelle pris og egenskaber på brættet.
 * @author Gruppe 37
 *
 */
public class Ejendom extends AbstractFelter {

	private boolean tilsalg = true;
	private int pris;
	private Spiller spiller;
	private String feltNavn;

	private int makkerFeltnr;

	/**
	 * Konstruktøren tager parametrene feltnr og gui.
	 * Konstruktøren består af en switch statement. Hver case har et feltnr, 
	 * og opretter ud fra feltnummeret, feltets individuelle navn og pris, samt makkerfelt
	 * 
	 * @param feltnr
	 * @param gui
	 */
	public Ejendom(int feltnr, GUI gui) {
		super(feltnr, gui);
		switch(feltnr){
		case 1: feltNavn = "Burgerbaren"; pris = 1; makkerFeltnr = 2;
		break;
		case 2: feltNavn = "Pizzariaet"; pris = 1; makkerFeltnr = 1;
		break;
		case 4: feltNavn = "Slikbutikken"; pris = 1; makkerFeltnr = 5;
		break;
		case 5: feltNavn = "Iskiosken"; pris = 1; makkerFeltnr = 4;
		break;
		case 7: feltNavn = "Museet"; pris = 2; makkerFeltnr = 8;
		break;
		case 8: feltNavn = "Biblioteket"; pris = 2; makkerFeltnr = 7;
		break;		
		case 10: feltNavn = "Skaterparken"; pris = 2; makkerFeltnr = 11;
		break;
		case 11: feltNavn = "Swimmingpool"; pris = 2; makkerFeltnr = 10;
		break;
		case 13: feltNavn = "Spillehallen"; pris = 3; makkerFeltnr = 14;
		break;
		case 14: feltNavn = "Biografen"; pris = 3; makkerFeltnr = 13;
		break;
		case 16: feltNavn = "Lejetøjsbutikken"; pris = 3; makkerFeltnr = 17;
		break;
		case 17: feltNavn = "Dyrehaven"; pris = 3; makkerFeltnr = 16;
		break;
		case 19: feltNavn = "Bowlinghallen"; pris = 4; makkerFeltnr = 20;
		break;
		case 20: feltNavn = "Zoo"; pris = 4; makkerFeltnr = 19;
		break;
		case 22: feltNavn = "Vandlandet"; pris = 5; makkerFeltnr = 23;
		break;
		case 23: feltNavn = "Stranpromenaden"; pris = 5; makkerFeltnr = 22;
		break;
		// Har valgt ikke at bruge default, fordi vi ved, at det ikke er en mulighed, at vi kommer dertil.
		}
	}


	/**
	 * toString til udskrivning af besked, når spilleren lander på feltet.
	 */
	@Override
	public String toString(){
		return "Du har landet på " + feltNavn;
	}

	
	/**
	 * setEjer setter ejeren til ejendomsfeltet, samt markerer selve feltet med spillerens farve
	 * @param spiller
	 */
	public void setEjer(Spiller spiller) {
		GUI_Field f = gui.getFields()[feltnr];
		if(f instanceof GUI_Ownable){
			GUI_Ownable o = (GUI_Ownable) f;
			o.setBorder(spiller.getFarve(), spiller.getFarve());
		}
		this.spiller = spiller;
	}

	public Spiller getEjer() {
		return spiller;
	}

	public void setTilsalg(boolean tilsalg){
		this.tilsalg = tilsalg;
	}
	/**
	 * Metode til at tjekke om et ejendomsgfelt er til salg
	 * @return
	 */
	public boolean isTilsalg(){
		return tilsalg;
	}

	/**
	 * landOnField indeholder ejendommens felt logik.
	 * Metoden tjekker om spilleren skal købe feltet, betale husleje, 
	 * eller ved et chancekortfår feltet gratis 
	 * 
	 * @param Spiller
	 */
	@Override
	public void landOnField(Spiller spiller){
		
		// Hvis ejendommen er til salg og spiller får den gratis ift. chancekort
		if(spiller.getGratis() && isTilsalg()){
			gui.showMessage(toString() + " og får grunden gratis!");
			spiller.tilførSkøde(feltnr, 0);
			setTilsalg(false);
			setEjer(spiller);
			spiller.setGratis(false);
		}
		// Hvis ejendommen er til salg og skal købes
		else if(isTilsalg()){
			gui.showMessage(toString() + " og køber grunden for " + pris+"M");
			spiller.tilførSkøde(feltnr, pris);
			setTilsalg(false);
			setEjer(spiller);
			spiller.setGratis(false);
		}
		// Hvis ejendommen ejes, og spiller skal betale husleje.
		else if(!isTilsalg()&& getEjer() != spiller){
			// Hvis ejeren af feltet, også ejer det andet felt i samme farve.
			if(getEjer().ejerEjendom(makkerFeltnr)){
				gui.showMessage(toString() + ". Da " + getEjer().getNavn() +" også ejer det andet felt af samme farve, skal "+ spiller.getNavn() +" betale dobbelt pris," + (2*pris) + "M til " + getEjer().getNavn());
				getEjer().ændrLikvideMidler(2*pris);
				spiller.ændrLikvideMidler(-2*pris);
			}
			else{
				gui.showMessage(toString() + " og skal betale " + pris + "M til " + getEjer().getNavn());
				getEjer().ændrLikvideMidler(pris);
				spiller.ændrLikvideMidler(-pris);
			}
			spiller.setGratis(false);
		}


	}
}
