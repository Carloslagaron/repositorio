package P3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Parking {

	private char maxZone;
	private int sizeZone;
	private char lowerElectricZone;
	private CarSpace[][] carSpaces;

	public Parking(String filename) throws FileNotFoundException {
		
		File lectura = new File(filename);
		Scanner input;
	
		input = new Scanner(lectura);


		String line = "";
		int detect_primera_linea = 0;

		while (input.hasNext()) {

			line = input.nextLine();

			if (line.startsWith("#")) {
				continue;
			} 
			
			if (detect_primera_linea == 0) {
				String[] parts = line.split(";");
				maxZone = parts[0].charAt(0);
				sizeZone = Integer.parseInt(parts[1]);
				lowerElectricZone = parts[2].charAt(0);
				carSpaces = new CarSpace[maxZone - 64][sizeZone];
				char zone = 65;

				for (int x = 0; x < carSpaces.length; x++) { // x recorre las filas
					for (int y = 0; y < carSpaces[x].length; y++) {

						Coordinate c = new Coordinate(zone, y + 1);
						carSpaces[x][y] = new CarSpace(c);
					}
					zone++;
				}

				detect_primera_linea++;
			} else {

				String[] parts = line.split(";");
				char zona = parts[0].charAt(0);
				String numero_s = parts[0].substring(1);
				int numero = Integer.valueOf(numero_s);
				String matricula = parts[1];
				Coordinate provisional = new Coordinate(zona,numero);
				for (int x = 0; x < carSpaces.length; x++) { // x recorre las filas
					for (int y = 0; y < carSpaces[x].length; y++) {
						
						if (provisional.toText().equals(carSpaces[x][y].getCoordinate().toText())) {
							carSpaces[x][y].setPlate(matricula);
						}
					}
				}
			}
		}
		for (int x = 0; x < carSpaces.length; x++) { // x recorre las filas
			for (int y = 0; y < carSpaces[x].length; y++) {
				
				if(carSpaces[x][y].getPlate() != "") {
				//System.out.println(carSpaces[x][y].getCoordinate().toText() + ";" + carSpaces[x][y].getPlate() + "  ");
				}
				
			}

		}
		
		
	}
	
	
	public void SaveParking (String fileName) {
		
	      try {
	    	File myObj = new File(fileName);
			myObj.createNewFile();	
			PrintWriter pw = new PrintWriter(fileName);
			pw.println(maxZone+";"+sizeZone+";"+lowerElectricZone);
			
			for (int x = 0; x < carSpaces.length; x++) { // x recorre las filas
				for (int y = 0; y < carSpaces[x].length; y++) {
					
					if(carSpaces[x][y].getPlate() != "") {
					pw.println(carSpaces[x][y].getCoordinate().toText() + ";" + carSpaces[x][y].getPlate() + "  ");
					}
					
				}

			}
			
			
			pw.close();
			
		} catch (IOException e) {}
	        
	}
	
	public void carEntry (String plate, char carType) {
		System.out.println("ENTRA UN COCHE: "+plate+"DEL TIPO: "+carType);
		if(carType == 'C') {
			
		for (int x = 0; x < lowerElectricZone-66; x++) { // x recorre las filas
			for (int y = 0; y < carSpaces[x].length; y++) {

				if (carSpaces[x][y].getPlate() == "") {
					carSpaces[x][y].setPlate(plate);
					System.out.println("La matricula de este coche es ahora "+ carSpaces[x][y].getPlate()+ "y esta en: "+carSpaces[x][y].getCoordinate().toText());
					return;
				}

			}
		}
		}
		if(carType == 'E' || carType == 'H') {

			for (int x = lowerElectricZone-65; x < maxZone-65; x++) { // x recorre las filas
				for (int y = 0; y < carSpaces[x].length; y++) {

					if (carSpaces[x][y].getPlate() == "") {
						carSpaces[x][y].setPlate(plate);
						System.out.println("La matricula de este coche es ahora "+ carSpaces[x][y].getPlate()+ "y esta en: "+carSpaces[x][y].getCoordinate().toText());
						return;
					}
					
				}
			}
		}
	}
	
	public void carDeparture (String plate) {
		System.out.println("SALE UN COCHE: "+plate);
		for (int x = 0; x < carSpaces.length; x++) { // x recorre las filas
			for (int y = 0; y < carSpaces[x].length; y++) {
				//System.out.println(carSpaces[x][y].getPlate() + "" + plate);
				if(carSpaces[x][y].getPlate().equals(plate)) {
					carSpaces[x][y].setPlate("");
					return;
				}
				
			}
		}
	}
}
