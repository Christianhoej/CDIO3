package nogetAndet;

public class Taber {
	private boolean taber;
	private int taberGrænse = 0;

	public void setTaber(boolean taber) {
		this.taber = taber;
	}
	
	public boolean isTaber() {
		return taber;
	}
	
	public void harTabt(int beholdningsværdi) {
		if(taberGrænse>beholdningsværdi)
			setTaber(true);
		else
			setTaber(false);
	}
}
