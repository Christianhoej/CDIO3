package entity;

public class Terning {

	private int værdi;
	private int maxVærdi = 6;
	private int minVærdi = 1;
	
	public Terning(int minVærdi, int maxVærdi){
		this.maxVærdi = maxVærdi;
		this.minVærdi = minVærdi;
	}
	public Terning(){
	}
	public int getVærdi() {
		return værdi;
	}
	public void kastTerning()
	{
		værdi =(int)(Math.random()*maxVærdi)+minVærdi;
	}
}
