package floristeria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteStock {

	Floristeria floristeria;
	
	public WriteStock(Floristeria floristeria) {
		this.floristeria = floristeria;
	}
	
	public void writeFitxer() {
		File ruta = new File("FloristeriaStock.txt");
		
		try {
			ruta.createNewFile();
		} catch (IOException e) {
			System.out.println("Error al crear el fitxer");
			e.printStackTrace();
		}
		
		try {
			FileWriter escriuText = new FileWriter(ruta);
			
			escriuText.write(floristeria.toString());
			escriuText.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
