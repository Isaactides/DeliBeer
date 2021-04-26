package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PruebaIS {

	public static void main(String[] args) {
		int puerto = 9000;
		
		try {
			ServerSocket server = new ServerSocket(puerto);
			while(true) {
				
				Socket socket = server.accept();
				InputStream is = socket.getInputStream();
				ObjectInputStream ois = new ObjectInputStream(is);
//				DataInputStream dataInputStream = new DataInputStream(is);
//				DataInputStream mailInputStream = new DataInputStream(is);
				
				/*
				String nombre = (String) ois.readObject();
				String apellido = (String) ois.readObject();
				String tipoPedido = (String) ois.readObject();
				Double precio = (Double) ois.readObject();
				*/
				
				
				
//				String mail = mailInputStream.readUTF();
//				String total = dataInputStream.readUTF();
				
				//Pedido p = new Pedido(nombre, apellido, "", tipoPedido, 1111, 1111, precio);
				String[] array = (String[]) ois.readObject();
				
				//generar pdf
				generarPDF(array[1], array[0]);
				//System.out.println(mail);
				//System.out.println(p.getApellidos());
				
				//mandar correo
				mandarCorreo(array[1]);
				ois.close();
//				mailInputStream.close();
//				dataInputStream.close();
				socket.close();
				is.close();
				
				
			}
		}catch (IOException | ClassNotFoundException e) {
			System.out.print("HOLA HOLA HOLA " + e.getMessage());
			e.printStackTrace();
		}

}


public static void generarPDF(String mail, String s) throws IOException {
	Document document = new Document();
      try
      {
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Pedido.pdf"));
         document.open();
         //document.add(new Paragraph("Datos de su pedido en Delibeer"));
         //document.add(new Paragraph("Pedido realizado por: " + p.getNombre() + " " + p.getApellidos()));
         //document.add(new Paragraph("Ha comprado un pack " + p.getTipo_pedido() + " a un precio de: " + p.getPrecio_pedido()));
         
         document.add(new Paragraph(s));
         
         document.close();
         writer.close();
      } catch (DocumentException e)
      {
         e.printStackTrace();
      } catch (FileNotFoundException e)
      {
         e.printStackTrace();
      }
	
}

public static void mandarCorreo(String mail) {
	
    String to = mail;
    
    String from = "delibeerdad@gmail.com";

    String host = "smtp.gmail.com";

    Properties properties = System.getProperties();

    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

        protected PasswordAuthentication getPasswordAuthentication() {

            return new PasswordAuthentication("delibeerdad@gmail.com", "delibeercorreo1");

        }

    });
    try {
        
        MimeMessage message = new MimeMessage(session);

        
        message.setFrom(new InternetAddress(from));

        
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

        
        message.setSubject("Recibo de compra en Delibeer");

        Multipart multipart = new MimeMultipart();

        MimeBodyPart attachmentPart = new MimeBodyPart();

        MimeBodyPart textPart = new MimeBodyPart();

        try {

            File f =new File("Pedido.pdf");

            attachmentPart.attachFile(f);
            textPart.setText("Gracias por comprar en delibeer, aqui está su recibo:");
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(attachmentPart);

        } catch (IOException e) {

            e.printStackTrace();

        }

        message.setContent(multipart);

        System.out.println("enviando mensaje...");

        Transport.send(message);
        System.out.println("Mensaje enviado ....");
    } catch (MessagingException mex) {
        mex.printStackTrace();
    }

}

}
