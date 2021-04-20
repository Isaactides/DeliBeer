package dad.delibeer.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import dad.delibeer.model.Pedido;

public class ServicioInterno {
	public ServicioInterno() {}

	public void enviar(Pedido pedido, String mail) {
		Socket cliente;
		int puerto = 9000;
		String ip = "127.0.0.1";

		try {
			cliente = new Socket(ip, puerto);
			OutputStream os = cliente.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			
			
			oos.writeObject(pedido);
			oos.writeObject(mail);
			oos.close();
			cliente.close();
			os.close();
		} catch (Exception e) {}
	}
	
	public String recibir() {
		Socket cliente;
		int puerto = 9000;
		String ip = "127.0.0.1";
		String url=null;
		try {
			cliente = new Socket(ip, puerto);
			BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			url = reader.readLine();
			cliente.close();
		} catch (Exception e) {}
		System.out.println(url);
		return url;
	}
}
