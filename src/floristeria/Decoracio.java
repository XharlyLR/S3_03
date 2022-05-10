package floristeria;

public class Decoracio implements Stock{

	String tipus;
	float preu;
	boolean isVenut = false;
	
	public Decoracio(Byte t, float preu) {
		this.preu = preu;
		
		if (t == 0)
			tipus = "FUSTA";
		else if (t == 1)
			tipus = "PLASTIC";
		else
			tipus = "DESCONEGUT";
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
		return "Decoracio [preu = " + preu + ", tipus = " + tipus + " isVenut = " + isVenut + "]";
	}
}
