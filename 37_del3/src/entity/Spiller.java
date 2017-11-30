package entity;

public class Spiller {
	private String navn;
	Aktivbeholdning aktivbeholdning = new Aktivbeholdning(0);
	private int placering=0;
	private int givKortVidere;
	private boolean fængsel;
	private boolean frikort;
	private boolean chancekort;
	private boolean gratis;
	
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
	
	public void setChancekort(boolean chancekort){
		this.chancekort = chancekort;
	}
	
	public boolean getChancekort(){
		return chancekort;
	}
	
	public void opdaterPlacering(int placering){
		this.placering += placering;
	}
	public void setPlacering(int placering){
		this.placering = placering;
	}
	
	public int getPlacering(){
		return placering;
	}
	
	public void setGratis(boolean gratis){
		this.gratis = gratis;
	}
	
	public boolean getGratis(){
		return gratis;
	}
	
	public void setGivKortVidere(int givKortVidere){
		this.givKortVidere = givKortVidere;
	}
	
	public int getGivKortVidere(){
		return givKortVidere;
	}
	
	
	
}
