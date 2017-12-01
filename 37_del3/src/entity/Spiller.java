package entity;

import java.awt.Color;

public class Spiller {
	private String navn;
	Aktivbeholdning aktivbeholdning = new Aktivbeholdning(0);

	private int placering=0;
	private Color farve;
	private boolean fængsel;
	private boolean frikort;
	private boolean fødselsdag;
	private boolean gratis;
	
	public Spiller(String navn) { 

		this.navn = navn;	}

	public String getNavn() {
		return navn;
	}
	public int kastTerning() {
		Kast kast = new Kast();
		kast.kastTerning();	
		int terningeVærdi = kast.getTerningVærdi();
		return terningeVærdi;
	}
	public void ændrLikvideMidler(int likvideMidler) {
		aktivbeholdning.addLikvideMidler(likvideMidler);

	}
	public void ændrAnlægsaktiverVærdi(int anlægsAktivetsVærdi) {
		aktivbeholdning.addAnlægsAktiver(anlægsAktivetsVærdi);

	}
	public int getLikvideMidler() {
		return aktivbeholdning.getLikvideMidler();
	}
	public int getAnlægsaktiver() {
		return aktivbeholdning.getAnlægsAktiver();
	}
	public void tilførSkøde(int feltNr, int skødepris) {
		aktivbeholdning.købSkøde(feltNr);
		ændrLikvideMidler(-skødepris);
		ændrAnlægsaktiverVærdi(skødepris);
	}
	public void sælgSkøde(int feltNr, int skødepris) {
		aktivbeholdning.sælgSkøde(feltNr);
		ændrLikvideMidler(skødepris);
		ændrAnlægsaktiverVærdi(-skødepris);
	}

	public boolean ejerEjendom(int feltNr){
		
		for(int i=0; i<aktivbeholdning.getSkøder().length; i++){
			if(aktivbeholdning.getSkøder()[i] == feltNr){
				return true;
			}
		}
		return false;
	}
	
	public void PasserStart(int feltNr){
		if(getPlacering() < feltNr){								// Hvis spilleren har passeret start, modtager spilleren 2M
			ændrLikvideMidler(2);
		}
	}
	
	public void setFarve(Color farve){
		this.farve = farve;
	}
	
	public Color getFarve(){
		return farve;
	}
	
	public void setFængsel(boolean fængsel){
		this.fængsel = fængsel;
	}
	
	public boolean isFængsel(){
		return fængsel;
	}
	
	public void setFrikort(boolean frikort){
		this.frikort = frikort;
	}
	
	public boolean getFrikort(){
		return frikort;
	}
		
	public void opdaterPlacering(int placering){
		this.placering += placering;
			if((placering)>23){
				this.placering = placering%24;
			}
	}
	public void setPlacering(int placering){
		this.placering = placering;
	}
	
	public int getPlacering(){
		return placering%24;
	}
	
	public void setGratis(boolean gratis){
		this.gratis = gratis;
	}
	
	public boolean getGratis(){
		return gratis;
	}	
	
	public void setFødselsdag(boolean fødselsdag){
		this.fødselsdag = fødselsdag;
	}
	
	public boolean getFødselsdag(){
		return fødselsdag;
	}
}
