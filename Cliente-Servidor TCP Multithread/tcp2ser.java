import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp2ser {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println(
					"Formato incorrecto, asegúrate de llamar a la función de la siguiente manera: tcp2ser port_number");
			return;
		}

		int PUERTO = Integer.parseInt(args[0]);

		ServerSocket servidor = null;
		Socket sc = null;

		try {

			System.out.println("<Servidor iniciado>");
			servidor = new ServerSocket(PUERTO);

			while (true) {
				sc = servidor.accept();
				ServidorHilo sh = new ServidorHilo(sc);
				sh.start();
			}
		} catch (IOException e) {
		}
	}
}

class ServidorHilo extends Thread {

	DataInputStream in;
	DataOutputStream out;
	Socket ServidorHilo;
	int acul;

	public ServidorHilo(Socket sc) {
		ServidorHilo = sc;
		System.out.println("Se ha conectado un nuevo cliente.");
	}

	public void run() {

		try {

			acul = 0;
			in = new DataInputStream(ServidorHilo.getInputStream());
			out = new DataOutputStream(ServidorHilo.getOutputStream());

		} catch (IOException e) {
		}

		try {
			while (true) {

				if (ServidorHilo.isClosed()) {
					break;
				}

				String mensaje = in.readUTF();
				int nuevo_num = Integer.parseInt(mensaje);

				acul += nuevo_num;
				out.writeUTF(String.valueOf(acul));
				System.out.println("El nuevo valor del acumulador es: " + acul + ".");

			}
		} catch (IOException e) {
		}
	}
}
