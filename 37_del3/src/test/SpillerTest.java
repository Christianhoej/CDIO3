package test;

import entity.Spiller;

public class SpillerTest {

	public static void main(String[] args){
		
		Spiller spiller = new Spiller("Gunn");
		// Tester, at ejendommene bliver gemt i spiller
		spiller.tilførSkøde(2, 1);
		spiller.tilførSkøde(5, 1);
		spiller.tilførSkøde(11, 2);
		spiller.tilførSkøde(1, 1);
		spiller.ejerEjendom(1);
		
//		if(spiller.ejerEjendom(1)){
//			System.out.println(spiller.getNavn() +" ejer ejendom 1");
//		}
//		
//		if(spiller.ejerEjendom(4)){
//			System.out.println(spiller.getNavn() +" ejer ejendom 4");
//		}
//		
//		if(spiller.ejerEjendom(2)){
//			System.out.println(spiller.getNavn() +" ejer ejendom 2");
//		}
//		
//		if(spiller.ejerEjendom(11)){
//			System.out.println(spiller.getNavn() +" ejer ejendom 10");
//		}
	}
}
