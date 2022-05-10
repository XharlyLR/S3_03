package floristeria;

public class Flor implements Stock{
	
	String color;
	float preu;
	boolean isVenut = false;
	
	public Flor(String color, float preu) {
		this.color = color;
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
		return "Flor [color = " + color + ", preu = " + preu + " isVenut = " + isVenut + "]";
	}
}
