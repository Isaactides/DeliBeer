package dad.delibeer.controllers;


import java.io.ObjectOutputStream;
import java.io.OutputStream;

import java.net.Socket;


public class ServicioInterno {
	public ServicioInterno() {}

	public void enviar(String nombre, String apellido, String tipo, Double precio, String mail) {
		Socket cliente;
		int puerto = 9000;
		//String ip = "127.0.0.1";

		try {
			cliente = new Socket("server", puerto);
			OutputStream os = cliente.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
	
			
			String total = "Datos de su Pedido en DeliBeer: \n" + "Pedido realizado por: " + nombre + " " + apellido + "\n Tipo de pedido: " + tipo + "\n Precio total: " + precio;
			
			String[] array = {total,mail};		
			oos.writeObject(array);
			oos.close();
			
			cliente.close();
			os.close();
		} catch (Exception e) {}
	}
	
}
