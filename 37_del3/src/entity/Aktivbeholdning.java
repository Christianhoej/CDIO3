package entity;

public class Aktivbeholdning {

	private int anlægsAktiver = 0;
	private int likvideMidler = 0;
	private int[]skøder = new int[16];

	public Aktivbeholdning(int likvideMidler) {
		this.likvideMidler = likvideMidler;

	}

	// Måske overflødig? ligger den ikke i skøde?
	public void addAnlægsAktiver(int anlægsAktiver) {
		this.anlægsAktiver += anlægsAktiver;
	}

	public int getAnlægsAktiver() {
		return anlægsAktiver;
	}

	public void addLikvideMidler(int likvideMidler) {
		this.likvideMidler += likvideMidler;
	}

	public int getLikvideMidler() {
		return likvideMidler;
	}
	public void købSkøde(int feltNr) {
		for(int i = 0; i<skøder.length; i++) {
			if (skøder[i] == 0) {
				skøder[i] =feltNr;
				break; 
			}
		}
	}
	public void sælgSkøde(int feltNr) {

		for(int i = 0; i<skøder.length; i++) {
			if (skøder[i] == feltNr) {
				skøder[i] = 0;
				break; 
			}
		}


	}

}