/**Klassen Chancekort genererer chancekort, samt har metoder til at trække og blande kort.
 * 
 */
package bræt;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Chancekort {
	private String[] kort;
	private String[] kort1;
	
	public Chancekort () {

		try {
			LavChanceKort("Dansk.txt");
		} catch (IOException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

/**LavChanceKort laver chancekort ud fra filen Dansk.txt hvor samtlige chancekort er opskrevet.
 * Metoden læser filen med Bufferreader og ........
 * @param fil
 * @throws IOException
 */



	public void LavChanceKort(String fil) throws IOException { //Metode opretter 24 chancekort som Strings og gemmer i arrayet "kort"

		BufferedReader br;
		br = new BufferedReader(new FileReader(fil));
		ArrayList<String> linjer = new ArrayList<String>();
		String currentLine = br.readLine();
		while(currentLine != null) {
			linjer.add(currentLine);
			currentLine = br.readLine();
		}
		br.close();
		// Convert to a String[] 
		kort = linjer.toArray(new String[]{});
		
		blandKort();
	}
/**Metoden trækker via et for-loop det øverste kort i bunken
 * 
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

/**Metoden blander bunken af chancekort så de ikke ligger i den rækkefølge de er skrevet i.
 * Giver kortet en tilfældig placering via Math.random
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