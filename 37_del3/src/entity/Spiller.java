package entity;


import nogetAndet.Tur;

public class Spiller {
	private String navn;

	Aktivbeholdning aktivbeholdning = new Aktivbeholdning(0);

	public Spiller(String navn) { 
		this.navn = navn;	}

	public String getNavn() {
		return navn;
	}
	public int brugTur() {//Tur Klassen er måske overflødig
		Tur tur = new Tur();
		int terningeVærdi = tur.brugTur();	
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
		return Aktivbeholdning.getBeholdning();
	}

	public int getSpillerNummer() {
		return spillerNummer;
	}
}
