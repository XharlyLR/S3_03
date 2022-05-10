package floristeria;

public class Arbre implements Stock{
	
	float alçada;
	float preu;
	boolean isVenut = false;

	public Arbre(float alçada, float preu) {
		this.alçada = alçada;
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
		return "Arbre [alçada = " + alçada + ", preu = " + preu + " isVenut = " + isVenut + "]";
	}

}
