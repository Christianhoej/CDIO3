package entity;

public class Aktivbeholdning {

	private int anlægsAktiver;
	private int startBeholdning;
	private int likvideMidler;
	
	public Aktivbeholdning() {

	}

	public void setAnlægsAktiver(int anlægsAktiver) {
		this.anlægsAktiver = anlægsAktiver;
	}
	
	public int getAnlægsAktiver() {
		return anlægsAktiver;
	}
	
	public void setLikvideMidler(int likvideMidler) {
		this.likvideMidler = likvideMidler;
	}
	
	public int getLikvideMidler() {
		return likvideMidler;
	}
	
	
}
