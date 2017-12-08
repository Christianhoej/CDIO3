
package bræt;


/**
 * Klassen Chancekort genererer chancekort, samt har metoder til at trække og blande kort.
 * 
 * @author Gruppe 37
 */

public class Chancekort {
	/**
	 * Erklæring String array, kaldet kort.
	 */
	private String[] kort;

	public Chancekort () {
		LavChanceKort();
	}

/**
 * Instantiering af string[], kort
 * 
 * LavChanceKort gemmer et String array af 16 chancekortchancekort
 */
	public void LavChanceKort() { 

		kort = new String[16];
		kort[0] = "Chance1#Ryk frem til START, og modtag M2.";
		kort[1] = "Chance2#Ryk op til 5 felter frem.";
		kort[2] = "Chance3#GRATIS FELT! Ryk frem til et orange felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
		kort[3] = "Chance4#Ryk 1 felt frem, eller tag et chancekort.";
		kort[4] = "Chance5#Du har spist for meget slik. BETAL M2 til banken.";
		kort[5] = "Chance6#GRATIS FELT! Ryk frem til et orange eller grønt felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
		kort[6] = "Chance7#GRATIS FELT! Ryk frem til et lyseblåt felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
		kort[7] = "Chance8#Du løslades uden omkostninger. Behold dette kort, indtil du får brug for det.";
		kort[8] = "Chance9#Ryk frem til Strandpromenaden";
		kort[9] = "Chance10#Det er din fødselsdag! Alle giver dig M1. TILLYKKE MED FØDSELDAGEN!";
		kort[10] = "Chance11#GRATIS FELT! Ryk frem til et pink eller mørkeblåt felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
		kort[11] = "Chance12#Du har lavet alle dine lektier. MODTAG M2 fra banken.";
		kort[12] = "Chance13#GRATIS FELT! Ryk frem til et rødt felt. Hvis det er ledigt, får du det GRATIS! Eller skal du BETALE leje til ejeren.";
		kort[13] = "Chance14#GRATIS FELT! Ryk frem til SKaterparken for at lave det perfekte grind! Hvis ingen ejer den, får du den GRATIS! Ellers skal du BETALE leje til ejeren.";
		kort[14] = "Chance15#GRATIS FELT! Ryk frem til et lyseblåt eller rødt felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";
		kort[15] = "Chance16#GRATIS FELT! Ryk frem til et brunt eller gult felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.";

		blandKort();
	}
	/**
	 * Metoden trækker via et for-loop det øverste kort i bunken
	 * @return Returnerer kortet der bliver trukket.
	 */
	public String traekKort(){
		String kort1 = kort[0];
		for(int i =0; i<kort.length-1;i++){
			kort[i] = kort[i+1];
		}
		kort[kort.length-1] = kort1;
		return kort1;
	}

	/**
	 * Metoden blander bunken af chancekort, så de ikke ligger i den rækkefølge, de er skrevet i.
	 * Metoden giver kortet en tilfældig placering i bunken via Math.random
	 */
	public void blandKort(){
		String[] kort1 = kort;
		int i = 0;
		kort1 = new String[kort.length];
		while(i < kort1.length) {
			int værdi =(int)(Math.random()*kort1.length);
			if(kort1[værdi]== null){
				kort1[værdi] = kort[i];
				i++;
			}
		}
		kort = kort1;		
	}
}