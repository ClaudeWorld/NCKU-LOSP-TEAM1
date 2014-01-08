import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendEmail
{
	void sendToClient(String mailClient, String titleString, String timeString, String urlString)
	{
		final String username = "tmpvirtual0@gmail.com";
		final String password = "affgg123";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mailClient));
			message.setSubject(titleString);//Title
			message.setText("Title: " + titleString + "\n\nTime: " + timeString + "\n\nurl: " + urlString);//Text
 
			Transport.send(message);
 
			System.out.println("Send success");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
