package prueba;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import dad.delibeer.model.Pedido;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*; 




public class pruebaMain {
	public static void main(String[] args) {
			int puerto = 9000;
			
			try {
				ServerSocket server = new ServerSocket(puerto);
				while(true) {
					Socket socket = server.accept();
					InputStream is = socket.getInputStream();
					ObjectInputStream ois = new ObjectInputStream(is);
					
					Pedido p = (Pedido) ois.readObject();
					String mail = (String) ois.readObject();
					generarPDF(mail, p);
					System.out.println(mail);
					System.out.println(p.getApellidos());
					
					ois.close();
					socket.close();
					is.close();
					
					socket = server.accept();
					PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
					File f = new File("Pedido.pdf");
					writer.print(f.toURL());
					writer.close();
					socket.close();
					
					
				}
			}catch (IOException | ClassNotFoundException e) {
				System.out.print(e);
			}

	}
	
	
	public static void generarPDF(String mail, Pedido p) throws IOException {
		Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Pedido.pdf"));
	         document.open();
	         document.add(new Paragraph("Datos de su pedido en Delibeer"));
	         document.add(new Paragraph("Pedido realizado por: " + p.getNombre() + " " + p.getApellidos()));
	         document.add(new Paragraph("Ha comprado un pack " + p.getTipo_pedido() + " a un precio de: " + p.getPrecio_pedido()));
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
	
//	public static void mandarCorreo() {
//		String to="XYZ@abc.com"; //Email address of the recipient
//        final String user="ABC@XYZ.com"; //Email address of sender
//        final String password="xxxxx";  //Password of the sender's email
//
//        //Get the session object      
//        Properties properties = System.getProperties();  
//
//        //Here pass your smtp server url
//        properties.setProperty("mail.smtp.host", "mail.javatpoint.com");   
//        properties.put("mail.smtp.auth", "true");    
//
//        Session session = Session.getDefaultInstance(properties,   
//                new javax.mail.Authenticator() {   
//            protected PasswordAuthentication getPasswordAuthentication() {   
//                return new PasswordAuthentication(user,password);    }   });       
//
//        //Compose message      
//        try{    
//            MimeMessage message = new MimeMessage(session);    
//            message.setFrom(new InternetAddress(user));     
//            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
//            message.setSubject("Message Aleart");         
//
//            //Create MimeBodyPart object and set your message text        
//            BodyPart messageBodyPart1 = new MimeBodyPart();     
//            messageBodyPart1.setText("This is message body");          
//
//            //Create new MimeBodyPart object and set DataHandler object to this object        
//            MimeBodyPart messageBodyPart2 = new MimeBodyPart();      
//            String filename = "YourPDFFileName.pdf";//change accordingly     
//            DataSource source = new FileDataSource(filename);    
//            messageBodyPart2.setDataHandler(new DataHandler(source));    
//            messageBodyPart2.setFileName(filename);             
//
//            //Create Multipart object and add MimeBodyPart objects to this object        
//            Multipart multipart = new MimeMultipart();    
//            multipart.addBodyPart(messageBodyPart1);     
//            multipart.addBodyPart(messageBodyPart2);      
//
//            //Set the multiplart object to the message object    
//            message.setContent(multipart );        
//
//            //Send message    
//            Transport.send(message);      
//            System.out.println("message sent....");   
//
//        }catch (MessagingException ex) {ex.printStackTrace();}
//	}

}
