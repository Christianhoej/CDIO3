package bræt;

import java.io.IOException;

public class TestAfKlasser {

	public static void main(String[] args) throws IOException {
Chancekort ch = new Chancekort();
ch.LavChanceKort("Dansk.txt");
for(int i = 0; i<20; i++){
	String ss = ch.traekKort();
System.out.println(i + " " + ss);
}

//ch.blandKort();
for(int j = 0; j<20; j++) {

String bb = ch.traekKort();
System.out.println( j + " " + bb);
	}
	}
}

