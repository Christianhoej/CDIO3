package bræt;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class skrivfil {
	public static void main(String[] args){
		try {
			skrivFil();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void skrivFil() throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter("Dansk.txt"));
		
		// kortene er skrevet ind fra venstre til højre -> nedad.
		bw.write("Chance1#Giv dette kort til BILEN, og tag et chancekort mere. BIL - På din næste tur skal du drøne frem til et hvilket som helst ledigt felt og købe det. Hvis der ikk er nogen ledige felter, skal du købe et fra en anden spiller.");
		bw.newLine();
		bw.write("Chance2#Ryk frem til START Modtag M2.");
		bw.newLine();
		bw.write("Chance3#Ryk op til 5 felter frem.");
		bw.newLine();
		bw.write("Chance4#GRATIS FELT! Ryk frem til et orange felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.");
		bw.newLine();
		bw.write("Chance5#Ryk 1 felt frem, eller tag et chancekort.");
		bw.newLine();
		bw.write("Chance6#Giv dette kort til SKIBET, og tag et chancekort mere. SKIB - På din næste tur skal du sejle frem til et hvilket som helst ledigt felt og købet det. Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller.");
		bw.newLine();
		bw.write("Chance7#Du har spist for meget slik. BETAL M2 til banken.");
		bw.newLine();
		bw.write("Chance8#GRATIS FELT! Ryk frem til et orange eller grønt felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.");
		bw.newLine();
		bw.write("Chance9#GRATIS FELT! Ryk frem til et lyseblåt felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.");
		bw.newLine();
		bw.write("Chance10#Du løslades uden omkostninger. Behold dette kort, indtil du får brug for det.");
		bw.newLine();
		bw.write("Chance11#Ryk frem til Strandpromenaden");
		bw.newLine();
		bw.write("Chance12#Giv dette kort til KATTEN, og tag et chancekort mere. KAT: På din næte tur skal du liste dig hen på et hvilken som helst ledigt felt og købe det. Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller.");
		bw.newLine();
		bw.write("Chance13#Giv dette kort til HUNDEN, og tag et chancekort mere. HUND: På din næste tur skal du hoppe hen på et hvilket som helst ledigt felt og købe det. Hvis der ikke er nogen ledige felter, skal du købe et fra en anden spiller.");
		bw.newLine();
		bw.write("Chance14#Det er din fødselsdag! Alle giver dig M1. TILLYKKE MED FØDSELDAGEN!");
		bw.newLine();
		bw.write("Chance15#GRATIS FELT! Ryk frem til et pink eller mørkeblåt felt. Hivs det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.");
		bw.newLine();
		bw.write("Chance16#Du har lavet alle dine lektier. MODTAG M2 fra banken.");
		bw.newLine();
		bw.write("Chance17#GRATIS FELT! Ryk frem til et rødt felt. Hvis det er ledigt, får du det GRATIS! Eller skal du BETALE leje til ejeren.");
		bw.newLine();
		bw.write("Chance18#GRATIS FELT! Ryk frem til SKaterparken for at lave det perfekte grind! Hvis ingen ejer den, får du den GRATIS! Ellers skal du BETALE leje til ejeren.");
		bw.newLine();
		bw.write("Chance19#GRATIS FELT! Ryk frem til et lyseblåt eller rødt felt. Hvis det er ledigt, får du det GRATIS! Ellers skal du BETALE leje til ejeren.");
		bw.newLine();
		bw.write("Chance20#GRATIS FELT! Ryk frem til et brunt eller gult. Hvis det er ledigt, får du det GRATIS! Eller skal du BETALE keje til ejeren.");
		bw.newLine();
		bw.close();
	}

}

