import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import java.io.IOException;
import java.net.DatagramPacket;

public class udpser {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Formato incorrecto, asegurate de introducir los siguientes datos: udpser port_number");
			return;
		}
		System.out.println("<Servidor iniciado>");
		int acul = 0;
		String puerto = args[0];
		int Puerto_a_int = Integer.parseInt(puerto);
		final int PUERTO = Puerto_a_int;


		try {
			 DatagramSocket socket = new DatagramSocket(PUERTO);
			 byte[] buffer = new byte[10000];
		while (true) {


				DatagramPacket recepcion = new DatagramPacket(buffer, buffer.length);

				socket.receive(recepcion);

				String mensaje = new String(recepcion.getData(), 0, recepcion.getLength());

				int nuevo_num = Integer.parseInt(mensaje);
				if(nuevo_num == 0) {
					System.out.println("\nSe recibio un 0. Fin de la comunicacion.");
					System.out.println("El valor final del acumulador fue: "+acul);
				} else {
					System.out.println("\nSe recibio el paquete cuyo contenido es: "+mensaje);
					acul = acul + nuevo_num;
					System.out.println("Se actualizo el contenido del acumulador a: "+acul);
				}



				String respuesta = String.valueOf(acul);
				byte[] respuesta_b = respuesta.getBytes();



				int puertoCliente = recepcion.getPort();

				InetAddress direccion = recepcion.getAddress();

				DatagramPacket envio = new DatagramPacket(respuesta_b, respuesta_b.length, direccion, puertoCliente);

				socket.send(envio);
		}
			} catch (SocketException ex) {
			} catch (IOException e) {
			}

	}

}
