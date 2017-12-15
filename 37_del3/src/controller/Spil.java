package controller;

import java.awt.Color;
import bræt.Bræt;
import entity.Spiller;
import entity.Taber;
import entity.Vinder;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;


/**
 * Den klasse der omsætter brugerens indtastninger
 * Styrer afviklingen af spillet
 * Spil klassen indeholder spillelogikken. 
 * 
 * @author Gruppe 37
 *
 */
public class Spil {

	GUI_Player[] s = new GUI_Player[4];
	GUI_Car[] car = new GUI_Car[4];
	String [] navn = new String[4];
	Color [] farve = {Color.blue, Color.red, Color.cyan, Color.orange};
	Taber taber = new Taber();
	Bræt b = new Bræt();		

	public void Start() {

		// Laver spillepladen
		GUI gui = new GUI(b.lavBræt());
		b.samlFelter(gui);

		// Afgører antal spillere
		String antal = gui.getUserSelection("Hvor mange spillere skal i være?", "2","3","4");
		int antalSpillere = Integer.parseInt(antal);
		Spiller[] spiller = new Spiller[antalSpillere];
 

		// Tilføjer spillerne til spillet
		for (int i=0; i<spiller.length; i++) {
			navn [i] = gui.getUserString("Indtast spiller " + (i+1) + "s navn");

			if(navn[i].equals("")){  // hvis der ikke er indtastet noget, sættes et standard spillernavn
				navn[i] = "Spiller " + (i+1);
			}

			//Opretter bilerne
			car[i]= new GUI_Car(farve[i], farve[i], GUI_Car.Type.CAR, GUI_Car.Pattern.HORIZONTAL_GRADIANT); 

			// Afgører startbalancen for spillerne og tilføjer dem til spillepladen
			//Bliver afgjort efter antalSpillere
			switch(antalSpillere) {
			case 2:
				s[i] = new GUI_Player(navn[i], 20, car[i]);
				break;
			case 3:
				s[i] = new GUI_Player(navn[i], 18, car[i]);
				break;
			case 4:
				s[i] = new GUI_Player(navn[i], 16, car[i]);
				break;
			default:
				break;
			}
			gui.addPlayer(s[i]);
			gui.getFields()[0].setCar(s[i], true);
			spiller[i] = new Spiller(s[i].getName());
			spiller[i].setFarve(farve[i]);
			spiller[i].ændrLikvideMidler(s[i].getBalance());
		}


		while(!taber.isTaber()) { // Mens ingen har tabt, køres spillet
			for(int i = 0; i < spiller.length; i++) {
				tjekFængsel(spiller[i]); // Tjekker om spilleren sidder i fængsel
				if(taber.isTaber()){ // Tjekkem om spiller har tabt
					break;
				}
				kastTerning(spiller[i], spiller, i, gui);   //Kaster terning
				int felt = tur(spiller[i], spiller, i, gui); // Bruger tur
				if(taber.isTaber()){  // Tjekker om spiller har tabt
					break;
				}

				// Hvis spilleren har trukket et chancekort, har ændret placering og derfor køber en ny ejendom.
				if(felt != spiller[i].getPlacering() && spiller[i].getPlacering() !=6){ // Hvis spillerens placering ikke er den samme, som før, og spilleren ikke er i fængsel
					tur(spiller[i], spiller, i, gui); // Bruger sin tur 
					if(taber.isTaber()){ // Tjekker om spiller har tabt
						break;
					}
				}
			}
		}
		Vinder vinder = new Vinder();
		gui.displayChanceCard((vinder.testHvemVinder(spiller))); // Finder vinderen

	}  //Metode Start slutter

	/**
	 * rykkerBrik flytter runt på brikken, og bruger landOnField til felt logikken
	 * @param spiller
	 * @param sp
	 * @param i
	 * @param gui
	 * @return felt - forrige placering
	 */
	public int tur(Spiller spiller, Spiller[] sp, int i, GUI gui){		
		int felt = spiller.getPlacering();									// Gemmer nuværende placering
		landOnField(spiller);		 										// Bruger logikken fra et felt
		gui.getFields()[felt].setCar(s[i], false);							// Fjerner bilen fra daværende placering
		gui.getFields()[spiller.getPlacering()].setCar(s[i], true);			// Sætter bilen på nye placering
		if(!spiller.isFængsel()){
			spiller.PasserStart(felt);
		}
		tjekFødselsdag(spiller, sp);
		setGUIBalance(s, sp);
		taber.harTabt(spiller.getLikvideMidler());
		return felt;
	}

	/**
	 * kastTerning kaster med terningen og rykker brikken det fram, som terningen viser
	 * @param spiller
	 * @param sp
	 * @param i
	 * @param gui
	 */
	public void kastTerning(Spiller spiller, Spiller[] sp, int i, GUI gui){

		gui.showMessage("Tryk OK for at slå med terningen");
		int terningVærdi = spiller.kastTerning();							// Kaster terningen
		gui.setDie(terningVærdi);											// Viser terningen på pladen
		int forrigePlacering = spiller.getPlacering();						// Gemmer forrige placering
		gui.getFields()[spiller.getPlacering()].setCar(s[i], false);			// Fjerner spillerens bil fra placering
		spiller.opdaterPlacering(terningVærdi);								// Opdaterer placering
		gui.getFields()[spiller.getPlacering()].setCar(s[i], true);			// Sætter bilen på nye placering
		spiller.PasserStart(forrigePlacering);								// Hvis spilleren har passeret start, modtager spilleren 2M
		setGUIBalance(s, sp);	
	}

	/**
	 * Opdaterer balancen
	 * @param s
	 * @param spiller
	 */
	public void setGUIBalance(GUI_Player[] s, Spiller spiller[]){
		for(int i =0; i<spiller.length; i++){								// Opdaterer balancen hos alle spillere på spillepladen
			s[i].setBalance(spiller[i].getLikvideMidler());
		}

	}
	/**
	 * Har felt logikken
	 * @param spiller
	 */
	public void landOnField(Spiller spiller){
		b.getSamlFelter()[spiller.getPlacering()].landOnField(spiller);
	}

	/**
	 * Tjekker, om spiller har fødselsdag (ud fra chancekort) og opdaterer spillernes balance
	 * @param sp
	 * @param spiller
	 */
	public void tjekFødselsdag(Spiller sp, Spiller[] spiller){
		if(sp.getFødselsdag()){
			sp.ændrLikvideMidler(spiller.length-1);
			for(int i=0; i<spiller.length; i++){
				if(sp !=spiller[i]){
					spiller[i].ændrLikvideMidler(-1);
				}
			}
			setGUIBalance(s, spiller);
		}

	}

	/**
	 * Tjekker om spiller er i fængsel, og i så fald, om han har et frikot eller skal betale for løsladelse
	 * @param spiller
	 */
	public void tjekFængsel(Spiller spiller){
		if(spiller.isFængsel()){												// Hvis spiller er i fængsel
			if(spiller.getFrikort()){										// Hvis spiller har get out of jail free kort, bruges det
				spiller.setFrikort(false);								
			}
			else{
				spiller.ændrLikvideMidler(-1);								// Ellers betaler spiller 1M for at komme ud
			}
			spiller.setFængsel(false);										// Spiller er ikke i fængsel længere
			taber.harTabt(spiller.getLikvideMidler());						// Tjekker om spiller har tabt.
		}
	}
}

