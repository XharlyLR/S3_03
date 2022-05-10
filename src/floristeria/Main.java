package floristeria;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static Floristeria floristeria;
	static WriteStock writeStock;
	
	public static void main(String[] args) {
		int op = 0;
		
		crearFloristeria();
		
		do {
			
			
			System.out.println("Marca amb el número coresponent l'opció a executar:\n"
					+ "0 - Tancar el programa\n"
					+ "1 - Crear altra floristeria\n"
					+ "2 - Afegir arbre\n"
					+ "3 - Afegir flor\n"
					+ "4 - Afegir decoracio\n"
					+ "5 - Veure stock total\n"
					+ "6 - Retirar arbre\n"
					+ "7 - Retirar flor\n"
					+ "8 - Retirar decoracio\n"
					+ "9 - Veure quantitats del stock\n"
					+ "10 - Veure valor total de la floristeria\n"
					+ "11 - Crear ticket de compra\n"
					+ "12 - Llistat de compres\n"
					+ "13 - Veure total de diner guanyat");
			op = sc.nextInt();
			sc.nextLine();
			
			switch (op) {
			case 0:
				break;
			case 1:
				crearFloristeria();
				break;
			case 2:
				introduirArbre((byte) 1);
				break;
			case 3:
				introduirFlor((byte) 1);
				break;
			case 4:
				introduirDecoracio((byte) 1);
				break;
			case 5:
				System.out.println(floristeria.allStock());
				break;
			case 6:
				introduirArbre((byte) 2);
				break;
			case 7:
				introduirFlor((byte) 2);
				break;
			case 8:
				introduirDecoracio((byte) 2);
				break;
			case 9:
				System.out.println(floristeria.quantStock());
				break;
			case 10:
				System.out.println("El valor total de la floristeria es: " + floristeria.valorTotalStock());
				break;
			case 11:
				crearTicket();
				break;
			case 12:
				System.out.println(floristeria.llistaTickets());
				break;
			case 13:
				System.out.println("El valor total venut es: " + floristeria.valorTotalVenut());
				break;
			default:
				System.out.println("Error al introduir el número\n");
				break;
			}
			
			writeStock.writeFitxer();
		} while (op != 0);
		
	}

	private static void crearTicket() {
		floristeria.nouTicket();
		int opT = 0;
		
		do {
			System.out.println("Marca amb el número coresponent l'article a afegir al ticket:\n"
					+ "0 - Sortir\n"
					+ "1 - Afegir arbre\n"
					+ "2 - Afegir flor\n"
					+ "3 - Afegir decoracio");
			opT = sc.nextInt();
			sc.nextLine();
			
			switch (opT) {
			case 0:
				floristeria.addTickets();
				break;
			case 1:
				introduirArbre((byte) 3);
				break;
			case 2:
				introduirFlor((byte) 3);
				break;
			case 3:
				introduirDecoracio((byte) 3);
				break;
			default:
				System.out.println("Error al introduir el número\n");
				break;
			}
		} while (opT != 0);
	}

	private static void introduirArbre(byte a) {
		float alçada;
		float preu;
		
		System.out.println("Introdueix l'alçada de l'arbre:");
		alçada = sc.nextFloat();
		sc.nextLine();
		
		System.out.println("Introdueix el preu de l'arbre:");
		preu = sc.nextFloat();
		sc.nextLine();
		
		switch (a) {
			case 1:
				floristeria.addArbres(new Arbre(alçada, preu));
				break;
			case 2:
				floristeria.removeArbres(floristeria.compararArbre(alçada, preu));
				break;
			case 3:
				floristeria.addStockTicket(floristeria.compararArbre(alçada, preu));
				break;
			default:
				System.out.println("Error, accio no realitzada!");
				break;
		}
	}
	
	private static void introduirFlor(byte a) {
		String color;
		float preu;
		
		System.out.println("Introdueix el color de la flor:");
		color = sc.nextLine().toLowerCase();
		
		System.out.println("Introdueix el preu de la flor:");
		preu = sc.nextFloat();
		sc.nextLine();
		
		switch (a) {
			case 1:
				floristeria.addFlors(new Flor(color, preu));
				break;
			case 2:
				floristeria.removeFlors(floristeria.compararFlor(color, preu));
				break;
			case 3:
				floristeria.addStockTicket(floristeria.compararFlor(color, preu));
				break;
			default:
				System.out.println("Error, accio no realitzada!");
				break;
		}
	}
	
	private static void introduirDecoracio(byte a) {
		Byte t;
		float preu;
		
		System.out.println("Introdueix 0 si el tipus de la decoracio es FUSTA, 1 si el tipus es PLASTIC:");
		t = sc.nextByte();
		sc.nextLine();
		
		System.out.println("Introdueix el preu de la decoracio:");
		preu = sc.nextFloat();
		sc.nextLine();
				
		switch (a) {
			case 1:
				floristeria.addDecoracions(new Decoracio(t, preu));
				break;
			case 2:
				floristeria.removeDecoracions(floristeria.compararDecoracio(t, preu));
				break;
			case 3:
				floristeria.addStockTicket(floristeria.compararDecoracio(t, preu));
				break;
			default:
				System.out.println("Error, accio no realitzada!");
				break;
		}
	}
	
	private static void crearFloristeria() {
		System.out.println("Introdueix el nom de la floristeria");
		floristeria = new Floristeria(sc.nextLine());
		
		writeStock = new WriteStock(floristeria);
	}

}
