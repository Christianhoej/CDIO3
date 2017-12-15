package test;

import entity.Spiller;

public class TestKast {
	public static void main(String[] args){
		Spiller spiller = new Spiller("Mads");
		
		int v=0; 
		int t[] = new int[6]; // Laver et array, hvor 
		int antal = 60000;
		System.out.println("Forekomster med en terning: ");
		System.out.println();
		for(int i=1; i<antal; i++){
			
			v = spiller.kastTerning();
			t[v-1]= t[v-1]+1;			
		}
		for(int i=1; i<=t.length;i++){ 
				System.out.println("Antal øjne: "+ i + ", \tforekomster: " + t[i-1]);
		}
	}
}
