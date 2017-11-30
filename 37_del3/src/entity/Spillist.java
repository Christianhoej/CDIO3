package entity;

public class Spillist {
	private Spiller[] spillere;
	
	public Spillist(String[] navn ) {
		spillere= new Spiller[navn.length];
		for (int i = 0;i < navn.length;i++)
			spillere[i]=new Spiller(navn[i]);
	} 
	
	public Spiller[] getSpillere(){
		return spillere;
	}
	
	public Spiller getSpiller(int index){
		return spillere[index];
	}
	
}
