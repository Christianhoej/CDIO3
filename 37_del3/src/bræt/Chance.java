/** Chance klassen nedarver atributter fra AbstracFelter Klassen.
 * Chance klassen udfører de forskellige chancekorts handlinger, og udskriver chancekortene på Gui'en
 */
package bræt;

import entity.Spiller; 
import gui_main.GUI;

public class Chance extends AbstractFelter {

	private Chancekort chance = new Chancekort();
	private String chanceBeskrivelse;
	private int arr[][];
	//private GUI gui;

/**Konstruktøren tager feltnr og giu .............
 * 
 * @param feltnr
 * @param gui
 */
	public Chance(int feltnr, GUI gui){
		super(feltnr, gui);
//		chance.blandKort();
	}

	//	@Override
	//	public void opretFelt(){
	//		felter[feltnr] = new GUI_Chance();
	//	}

	@Override
	public String toString(){
		return "Du har landet på Chancen, tryk OK for at trække et kort.";
	}

	public void setChancekort(){
		chanceBeskrivelse = chance.traekKort();
	}

	public String getChancekort(){
		return chanceBeskrivelse.split("#")[1];
	}

	public void setChanceHandling(){
		arr = new int[12][];
		arr[2] = new int[4];
		switch (chanceBeskrivelse.split("#")[0]){
		case "Chance1": arr[0][0] = 1; break;
		case "Chance2": arr[8][0] = 0; break;
		case "Chance3": arr[1][0] = 5; break;
		case "Chance4": arr[2][0] = 16;
		arr[2][1] = 17; 
		arr[7][0] = 1; break;
		case "Chance5": arr[1][0] = 1;
		arr[7][0] = 1; break;
		case "Chance6": arr[0][0] = 2; break;
		case "Chance7": arr[4][0] = 2; break;
		case "Chance8": arr[2][0] = 16;
		arr[2][1] = 17; 
		arr[2][2] = 19;
		arr[2][3] = 20;
		arr[7][0] = 1; break;
		case "Chance9": arr[2][0] = 4;
		arr[2][1] = 5;
		arr[7][0] = 1; break;
		case "Chance10":arr[10][0] = 1; break;
		case "Chance11":arr[8][0] = 23; break;
		case "Chance12":arr[0][0] = 3; break;
		case "Chance13":arr[0][0] = 4; break;
		case "Chance14":arr[11][0] = 1; break;
		case "Chance15":arr[2][0] = 7;
		arr[2][1] = 8; 
		arr[2][2] = 22;
		arr[2][3] = 23;
		arr[7][0] = 1; break;
		case "Chance16":arr[3][0] = 2; break;
		case "Chance17":arr[2][0] = 13;
		arr[2][1] = 14; 
		arr[7][0] = 1; break;
		case "Chance18":arr[8][0] = 10;
		arr[7][0] = 1; break;
		case "Chance19":arr[2][0] = 4;
		arr[2][1] = 5; 
		arr[2][2] = 13;
		arr[2][3] = 14;
		arr[7][0] = 1; break;
		case "Chance20":arr[2][0] = 1;
		arr[2][1] = 2; 
		arr[2][2] = 10;
		arr[2][3] = 11;
		arr[7][0] = 1; break;
		}	
	}

	public int[][] getChanceHandling(){
		return arr;
	}

	@Override
	public void landOnField(Spiller spiller) {
		String felt;
		gui.showMessage(toString() + " og trækker et chancekort");
		gui.setChanceCard(toString());
		setChancekort(); 
		boolean nytKort = false;
		while(!nytKort){
			nytKort = false;

			switch (chanceBeskrivelse.split("#")[0]){
			case "Chance1": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.setGivKortVidere(0); 
							nytKort = true;
							break;
				
			case "Chance2": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.setPlacering(0);
							break;
				
			case "Chance3": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvor mange felter vil du rykke frem?", "0","1","2","3","4","5");
							spiller.setPlacering(Integer.parseInt(felt));
							break;
				
			case "Chance4": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvilket orange felt vil du rykke frem til?", "16", "17");
							spiller.setGratis(true);
							spiller.setPlacering(Integer.parseInt(felt));
							break;
				
			case "Chance5": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserButtonPressed("Vil du rykke et felt frem eller tage et chancekort?", "Ryk et felt frem", "Tag chancekort");
							if(felt.equals("Ryk et felt frem")){
								spiller.setPlacering(spiller.getPlacering()+1);
							}
							else{
								nytKort = true;
							}
							break;
							
			case "Chance6": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.setGivKortVidere(1); 
							nytKort = true;
							break;
				
			case "Chance7": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							gui.showMessage("Du skal betale 2M til banken");
							spiller.ændrLikvideMidler(-2);
							break;
				
			case "Chance8": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvilket orange eller grønt felt vil du rykke frem til?", "16", "17", "19", "20");
							spiller.setGratis(true);
							spiller.setPlacering(Integer.parseInt(felt));
							break; 
			
			case "Chance9": gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "4", "5");
							spiller.setGratis(true);
							spiller.setPlacering(Integer.parseInt(felt));
							break;

			case "Chance10":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.setFrikort(true);
							break;
							
			case "Chance11":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.setPlacering(23);
							break;
							
			case "Chance12":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.setGivKortVidere(3); 
							nytKort = true;
							break;
							
			case "Chance13":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.setGivKortVidere(4); 
							nytKort = true;
							break;
							
			case "Chance14":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							break;
							
			case "Chance15":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "7", "8", "22", "23");
							spiller.setGratis(true);
							spiller.setPlacering(Integer.parseInt(felt));
							break;
							
			case "Chance16":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							spiller.ændrLikvideMidler(2);
							
			case "Chance17":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "13", "14");
							spiller.setGratis(true);
							spiller.setPlacering(Integer.parseInt(felt));
							break;
							
			case "Chance18":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							gui.showMessage("Ryk frem til Skaterparken");
							spiller.setGratis(true);
							spiller.setPlacering(10);
							break;
							
			case "Chance19":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "4", "5", "13", "14");
							spiller.setGratis(true);
							spiller.setPlacering(Integer.parseInt(felt));
							break;
							
			case "Chance20":gui.setChanceCard(chanceBeskrivelse.split("#")[1]);
							felt = gui.getUserSelection("Hvilket lyseblåt felt vil du rykke frem til?", "1", "2", "10", "11");
							spiller.setGratis(true);
							spiller.setPlacering(Integer.parseInt(felt));
							break;
			}
		}	
	}
}
