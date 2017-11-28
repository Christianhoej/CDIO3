package entity;

public class Spiller {
	private String navn;
	private int spillerNummer;
	private Aktivbeholdning Aktivbeholdning;
	
	public Spiller(String navn, int spillerNummer, int Aktivbeholdning) {
		this.navn = navn;
		Aktivbeholdning = new Aktivbeholdning(startBeholdning,0,antalSpillerePenge);
	}
	
	public String getNavn() {
		return navn;
	}

	public int getPoint() {
		return Aktivbeholdning.getBeholdning();
	}
	
	public int getSpillerNummer() {
		return spillerNummer;
	}
}
