package dad.delibeer.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;


public class ServicioInterno {
	public ServicioInterno() {}

	public void enviar(String nombre, String apellido, String tipo, Double precio, String mail) {
		Socket cliente;
		int puerto = 9000;
		String ip = "127.0.0.1";

		try {
			cliente = new Socket(ip, puerto);
			OutputStream os = cliente.getOutputStream();
//			OutputStreamWriter osw = new OutputStreamWriter(os);
//            BufferedWriter bw = new BufferedWriter(osw);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			//BufferedReader reader = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			
//			String nombreAux = pedido.getNombre();
//			String apellidoAux = pedido.getApellidos();
//			String tipoPedidoAux = pedido.getTipo_pedido();
//			Double precioAux = pedido.getPrecio_pedido();
			
			String total = "Datos de su Pedido en DeliBeer: \n" + "Pedido realizado por: " + nombre + " " + apellido + "\n Tipo de pedido: " + tipo + "\n Precio total: " + precio;
			
			String[] array = {total,mail};
//			bw.write(total);
//			bw.flush();
//			bw.close();
			
			
			/*
			oos.writeUTF(pedido.getNombre());
			oos.writeUTF(pedido.getApellidos());
			oos.writeUTF(pedido.getTipo_pedido());
			oos.writeDouble(pedido.getPrecio_pedido());
			
			oos.writeObject(nombreAux);
			oos.writeObject(apellidoAux);
			oos.writeObject(tipoPedidoAux);
			oos.writeObject(precioAux);
			*/
			oos.writeObject(array);
			oos.close();
			
			cliente.close();
			os.close();
		} catch (Exception e) {}
	}
	
}
