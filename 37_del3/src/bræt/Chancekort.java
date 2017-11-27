package bræt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Chancekort {
	private String[] kort;
	
	public Chancekort () {

	}

	public void LavChanceKort(String fil) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fil));
		ArrayList<String> linjer = new ArrayList<String>();
		String currentLine = reader.readLine();
		while(currentLine != null) {
		    linjer.add(currentLine);
		    currentLine = reader.readLine();
		}
		reader.close();

		// Convert to a String[] 
		kort = linjer.toArray(new String[]{});
	}
	
	public String traekKort(){
		String kort1 = kort[0];
		for(int i =0; i<kort.length-1;i++){
			kort[i] = kort[i+1];
		}
		kort[kort.length-1] = kort1;
		return kort1;
	}
	
	public void blandKort(){
		String[] kort1 = kort;
		int i = 0;
		while(i < kort1.length) {
			int værdi =(int)(Math.random()*52);
			if(kort1[værdi]== null){
				kort1[værdi] = kort[i];
				i++;
			}
		}
		kort = kort1;		
	}
	
}
