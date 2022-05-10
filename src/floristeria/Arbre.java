package floristeria;

public class Arbre implements Stock{
	
	float al�ada;
	float preu;
	boolean isVenut = false;

	public Arbre(float al�ada, float preu) {
		this.al�ada = al�ada;
		this.preu = preu;
	}

	@Override
	public float getPreu() {
		return preu;
	}

	@Override
	public boolean isVenut() {
		return isVenut;
	}

	@Override
	public void setVenut(boolean isVenut) {
		this.isVenut = isVenut;
	}

	@Override
	public String toString() {
		return "Arbre [al�ada = " + al�ada + ", preu = " + preu + " isVenut = " + isVenut + "]";
	}

}
