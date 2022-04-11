import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.net.DatagramPacket;

public class udpcli {

	public static void main(String[] args) {

		try {
			DatagramSocket socket = new DatagramSocket();

			if (args.length != 2) {
				System.out.println("Formato incorrecto, asegurate de llamar a la funcion de la siguiente manera: udpcli ip_adress port_number");
				return;
			}
			System.out.println("<Cliente iniciado>");
			DatagramPacket envio;
			DatagramPacket recepcion;


			Scanner sc = new Scanner(System.in);
			socket.setSoTimeout(10000);

			String mensaje;

			String ip = args[0];
			int Puerto_a_int = Integer.parseInt(args[1]);
			final int PUERTO_SERVIDOR = Puerto_a_int;

			byte[] buffer = new byte[10000];
			byte[] buffer_recepcion = new byte[10000];

			String valor_final = null;

			while (true) {

				System.out.print("Introduce un numero a enviar: ");
				int numero_x = sc.nextInt();
				if (numero_x == 0) {
					System.out.println("\nEl envio ha finalizado, Cliente cerrado.");
					System.out.println("El valor final del acumulador ha sido: " + valor_final);
					String numero_x_string = String.valueOf(numero_x);

					InetAddress direccion = InetAddress.getByName(ip);
					mensaje = String.valueOf(numero_x_string);
					buffer = mensaje.getBytes();

					envio = new DatagramPacket(buffer, buffer.length, direccion, PUERTO_SERVIDOR);

					socket.send(envio);
					socket.close();
				}

				String numero_x_string = String.valueOf(numero_x);

				InetAddress direccion = InetAddress.getByName(ip);
				mensaje = String.valueOf(numero_x_string);
				buffer = mensaje.getBytes();

				envio = new DatagramPacket(buffer, buffer.length, direccion, PUERTO_SERVIDOR);

				socket.send(envio);

				recepcion = new DatagramPacket(buffer_recepcion, buffer_recepcion.length);

				socket.receive(recepcion);

				mensaje = new String(recepcion.getData());
				valor_final = mensaje;



				System.out.println("Respuesta del servidor: El acumulador contiene ahora el valor: " + mensaje);

			}
		} catch (SocketException e) {
		} catch (SocketTimeoutException e) {
			System.out.println("Se acabo el tiempo maximo de espera.");
		} catch (IOException e) {
		} catch (InputMismatchException e) {
			System.out.println("Tienes que introducir un numero.");
		}
	}
}
