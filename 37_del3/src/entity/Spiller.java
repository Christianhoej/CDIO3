package entity;

public class Spiller {
	private String navn;
	Aktivbeholdning aktivbeholdning = new Aktivbeholdning(0);
	private int placering;
	private boolean fængsel = false;
	private boolean frikort = false;
	
	
	public Spiller(String navn) {
		this.navn = navn;	}

	public String getNavn() {
		return navn;
	}
	public int kastTerning() {//Tur Klassen er måske overflødig 
		// Har valgt at bruge kast istedet for Tur
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
		int totalLikvideMidler = aktivbeholdning.getLikvideMidler();
		return totalLikvideMidler;
	}
	public int getAnlægsaktiver() {
		int totalAnlægsaktiver = aktivbeholdning.getAnlægsAktiver();
		return totalAnlægsaktiver;
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

	public int getPoint() {
		return aktivbeholdning.getLikvideMidler();
	}

//	public int getSpillerNummer() {
//		return spillerNummer;
//	}
	
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
	
	public void setPlacering(int placering){
		this.placering = placering;
	}
	
	public int getPlacering(){
		return placering;
	}
	
}
