
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class tcp2cli {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println(
					"Formato incorrecto, asegúrate de llamar a la función de la siguiente manera: tcp2cli ip_adress port_number");
			return;
		}

		String ip = args[0];
		int PUERTO = Integer.parseInt(args[1]);

		DataInputStream in = null;
		DataOutputStream out = null;

		Scanner scanner = new Scanner(System.in);
		Socket sc = null;
		try {
			Socket soc = new Socket();

			SocketAddress socketAddress = new InetSocketAddress(ip, PUERTO);

			soc.connect(socketAddress, 15000);
		} catch (SocketTimeoutException e) {
			System.out.println("Se ha excedido el tiempo maximo de espera.");
			return;
		} catch (IOException e) {
		}
		try {

			System.out.println("<Cliente iniciado>");
			sc = new Socket(ip, PUERTO);

			in = new DataInputStream(sc.getInputStream());
			out = new DataOutputStream(sc.getOutputStream());

		} catch (IOException e) {
		}

		try {

			while (true) {

				System.out.print("Introduce un número a enviar: ");
				int numero_x = scanner.nextInt();

				if (numero_x == 0) {
					sc.close();
					break;
				}

				String numero_x_string = String.valueOf(numero_x);
				out.writeUTF(numero_x_string);

				String mensaje = in.readUTF();
				System.out.println("El acumulador vale ahora: " + mensaje);

			}
		} catch (IOException ex) {
		}
	}
}
