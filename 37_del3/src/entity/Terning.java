/**Terning-klassen anvendes til at angive en værdi for en terning. 
 * Klassen er kodet således at den opretter én seks-siddet terning med værdi fra 1-6
 */
package entity;

public class Terning {

	private int værdi;
	private int maxVærdi = 6;
	private int minVærdi = 1;
	/**
	 * Konstruktøren Terning oprettes med en minimum og maksimum værdi
	 * @param minVærdi 1
	 * @param maxVærdi 6
	 */
	public Terning(int minVærdi, int maxVærdi){
		this.maxVærdi = maxVærdi;
		this.minVærdi = minVærdi;
	}
	
	public Terning(){
	}
	
	public int getVærdi() {
		return værdi;
	}
	/**
	 * Metode til kast af terning.
	 * Returnerer en tilfældig værdi mellem 1-6
	 */
	public void kastTerning()
	{
		værdi =(int)(Math.random()*maxVærdi)+minVærdi;
	}
}
