package floristeria;

import java.util.ArrayList;

public class Ticket {

	ArrayList<Stock> ticketCompra = new ArrayList<Stock>();
	
	public void addStock(Stock stock) {
		ticketCompra.add(stock);
		System.out.println("Article introduit");
	}
	
	public float preuCompra() {
		float valor = 0;
		
		for (Stock stock : ticketCompra) {
			valor += stock.getPreu();
		}
		
		return valor;
	}

	@Override
	public String toString() {
		return "Ticket [" + ticketCompra + "]";
	}
	
}
