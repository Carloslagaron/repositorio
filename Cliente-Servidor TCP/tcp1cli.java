
import java.net.Socket;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class tcp1cli {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Formato incorrecto, asegurate de llamar a la funcion de la siguiente manera: tcp1cli ip_adress port_number");
			return;
		}

		String ip = args[0];
		int PUERTO = Integer.parseInt(args[1]);
		DataInputStream in;
		DataOutputStream out;
		Scanner scanner = new Scanner(System.in);

		try {


			while (true) {
				Socket sc = new Socket(ip, PUERTO);

				in = new DataInputStream(sc.getInputStream());
				out = new DataOutputStream(sc.getOutputStream());

				System.out.print("Introduce un numero a enviar, el 0 finaliza la comunicacion: ");
				int numero_x = scanner.nextInt();
				if (numero_x == 0) {
					String numero_x_string = String.valueOf(numero_x);
					out.writeUTF(numero_x_string);
					sc.close();
					break;
				}
				String numero_x_string = String.valueOf(numero_x);

				out.writeUTF(numero_x_string);
				String acu = in.readUTF();
				
				System.out.println("El valor recibido es: "+acu);
				
			}
		} catch (IOException ex) {
		}

	}
}
