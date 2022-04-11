import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp1ser {

	public static void main(String[] args) throws IOException {
	
		if (args.length != 1) {
			System.out.println("Formato incorrecto, asegurate de llamar a la funcion de la siguiente manera: tcp1ser port_number");
			return;
		}

		ServerSocket servidor = null;
		Socket sc = null;
		DataInputStream in;
		DataOutputStream out;
		int acul = 0;

		int PUERTO = Integer.parseInt(args[0]);

		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor iniciado");

			while (true) {

				acul = 0;
				int cuenta = 0;
				

				
			try{
				while (true) {
					
					
					
					
					sc = servidor.accept();
					cuenta++;
					if(cuenta == 1) {
						System.out.println("Se ha conectado un nuevo cliente.");
						cuenta++;
					}
					in = new DataInputStream(sc.getInputStream());
					out = new DataOutputStream(sc.getOutputStream());
					
					String mensaje = in.readUTF();

					int nuevo_num = Integer.parseInt(mensaje);

					acul += nuevo_num;
					
					if (nuevo_num == 0) {
						System.out.println("Se ha recibido un 0, envio finalizado");
						sc.close();
						break;
					}
					
					String acul_string = String.valueOf(acul);
					
					System.out.println("Se ha recibido un paquete con el valor " + mensaje + ".");
					System.out.println("El nuevo valor del acumulador es: " + acul + ".");
					
					out.writeUTF(acul_string);
					
				}
				} catch (IOException e) {
					System.out.println("El cliente se desconecto de forma abrupta.");
				}
			}
		} catch (IOException e) {
		
		}

	}
}
