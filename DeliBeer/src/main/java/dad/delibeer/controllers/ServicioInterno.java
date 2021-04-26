package dad.delibeer.controllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
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
			//ObjectOutputStream oos = new ObjectOutputStream(os);
			DataOutputStream dataOutputStream = new DataOutputStream(os);
			DataOutputStream dataMail = new DataOutputStream(os);
			//BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
			String nombreAux = pedido.getNombre();
			String apellidoAux = pedido.getApellidos();
			String tipoPedidoAux = pedido.getTipo_pedido();
			Double precioAux = pedido.getPrecio_pedido();
			
			String total = "Datos de su Pedido en DeliBeer: \n" + "Pedido realizado por: " + pedido.getNombre() + " " + pedido.getApellidos() + "\n Tipo de pedido: " + pedido.getTipo_pedido() + "\n Precio total: " + pedido.getPrecio_pedido();
			
			dataOutputStream.writeUTF(total);
			dataOutputStream.flush();
			dataOutputStream.close();
			
			dataMail.writeUTF(mail);
			dataMail.flush();
			dataMail.close();
			
			/*
			oos.writeUTF(pedido.getNombre());
			oos.writeUTF(pedido.getApellidos());
			oos.writeUTF(pedido.getTipo_pedido());
			oos.writeDouble(pedido.getPrecio_pedido());
			
			oos.writeObject(nombreAux);
			oos.writeObject(apellidoAux);
			oos.writeObject(tipoPedidoAux);
			oos.writeObject(precioAux);
			
			oos.writeObject(mail);
			oos.close();
			*/
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
