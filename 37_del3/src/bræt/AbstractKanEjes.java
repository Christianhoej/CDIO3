package bræt;

import entity.Spiller;

public abstract class AbstractKanEjes extends AbstractFelter{
	
	public AbstractKanEjes(int feltnr) {
		super(feltnr);	
	}
	
	public abstract String toString();
	
	public abstract void setEjer(Spiller ejer);
	public abstract Spiller getEjer();
	
	public abstract void fjernEjer();
	public abstract int getLeje();
	
	public abstract void setTilsalg(boolean tilsalg);
	public abstract boolean getTilsalg();
	
	public abstract void landOnField(int feltnr);
}
