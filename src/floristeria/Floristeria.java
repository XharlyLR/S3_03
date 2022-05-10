package floristeria;

import java.util.ArrayList;

public class Floristeria {

	String nom;
	ArrayList<Arbre> arbres = new ArrayList<Arbre>();
	ArrayList<Flor> flors = new ArrayList<Flor>();
	ArrayList<Decoracio> decoracions = new ArrayList<Decoracio>();
	ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	Ticket ticket;
	
	public Floristeria(String nom) {
		this.nom = nom;
	}

	public void addArbres(Arbre arbre) {
		arbres.add(arbre);
	}

	public void addFlors(Flor flor) {
		flors.add(flor);
	}

	public void addDecoracions(Decoracio decoracio) {
		decoracions.add(decoracio);
	}
	
	public String allStock() {
		return "Stock de la floristeria " + nom + ":\n"
				+ "Arbres:"
				+ "	" + arbres + "\n"
				+ "Flors:"
				+ "	" + flors + "\n"
				+ "Decoracions:"
				+ "	" + decoracions;
	}

	public Arbre compararArbre(float alçada, float preu) {
		for (Arbre arbre : arbres) {
			if (arbre.alçada == alçada && arbre.getPreu() == preu) {
				return arbre;
			}
		}
		System.out.println("No s'ha trobat l'arbre");
		return null;
	}

	public Flor compararFlor(String color, float preu) {
		for (Flor flor : flors) {
			if (flor.color.equalsIgnoreCase(color) && flor.getPreu() == preu) {
				return flor;
			}
		}
		System.out.println("No s'ha trobat la flor");
		return null;		
	}

	public Decoracio compararDecoracio(byte t, float preu) {
		String tipus;
		if (t == 0)
			tipus = "FUSTA";
		else if (t == 1)
			tipus = "PLASTIC";
		else
			tipus = "DESCONEGUT";
		
		for (Decoracio decoracio : decoracions) {
			if (decoracio.tipus.equalsIgnoreCase(tipus) && decoracio.getPreu() == preu) {
				return decoracio;
			}
		}
		System.out.println("No s'ha trobat la decoracio");
		return null;
	}
	
	public void removeArbres(Arbre arbre) {
		if (arbre != null) {
			arbres.remove(arbre);
			System.out.println(arbre + " eliminat");
		}
	}
	
	public void removeFlors(Flor flor) {
		if (flor != null) {
			flors.remove(flor);
			System.out.println(flor + " eliminada");
		}
	}

	public void removeDecoracions(Decoracio decoracio) {
		if (decoracio != null) {
			decoracions.remove(decoracio);
			System.out.println(decoracio + " eliminada");
		}
	}
	
	public String quantStock() {
		return "Quantitats:\n" 
				+ "Arbres: " + arbres.size()
				+ "\nFlors: " + flors.size()
				+ "\nDecoracions: " + decoracions.size();
	}
	
	public float valorTotalStock() {
		float valor = 0;
		
		for (Arbre arbre : arbres) {
			if (!arbre.isVenut())
				valor += arbre.getPreu();
		}
		
		for (Flor flor : flors) {
			if (!flor.isVenut())
				valor += flor.getPreu();
		}
		
		for (Decoracio decoracio : decoracions) {
			if (!decoracio.isVenut())
				valor += decoracio.getPreu();
		}
		
		return valor;
	}
	
	public void nouTicket() {
		ticket = new Ticket();
	}
	
	public void addStockTicket(Stock stock) {
		if (stock != null) {
			stock.setVenut(true);
			ticket.addStock(stock);
		}
	}
	
	public void addTickets() {
		if (ticket != null)
			tickets.add(ticket);
	}
	
	public String llistaTickets() {
		return "Compres:\n"
				+ tickets;
	}
	
	public float valorTotalVenut() {
		float valor = 0;
		
		for (Ticket ticket : tickets) {
			valor += ticket.preuCompra();
		}
		
		return valor;
	}

	@Override
	public String toString() {
		String arbresString = "";
		for (Arbre arbre : arbres) {
			arbresString += "\n	" + arbre;
		}
		
		String florsString = "";
		for (Flor flor : flors) {
			florsString += "\n	" + flor;
		}
		
		String decoracionsString = "";
		for (Decoracio decoracio : decoracions) {
			decoracionsString += "\n	" + decoracio;
		}
		
		String ticketsString = "";
		for (Ticket ticket : tickets) {
			ticketsString += "\n	" + ticket;
		}
		
		return "Stock floristeria \"" + nom + "\":\n"
				+ "Arbres:"
				+ "	" + arbresString
				+ "\nFlors:"
				+ "	" + florsString 
				+ "\nDecoracions:"
				+ "	" + decoracionsString
				+ "\nTickets:"
				+ "	" + ticketsString;
	}
	
}
