package P3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P3b {

	public static void main(String[] args) throws FileNotFoundException {

		Parking parking = new Parking(args[0]);
		
		File lectura = new File(args[1]);

		Scanner input = null;
		
		input = new Scanner(lectura);

			String line = "";

			while (input.hasNext()) {
				line = input.nextLine();
				if (line.startsWith("#")) {
					continue;
				} 
				String[] parts = line.split(";");
				if (parts[0].equals("I")) {
					parking.carEntry(parts[1], parts[2].charAt(0));

				} 
				if (parts[0].equals("O")) {
					parking.carDeparture(parts[1]);
					
				}
				}

			parking.SaveParking(args[2]);
		

	}
}