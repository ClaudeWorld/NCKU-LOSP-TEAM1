import java.util.ArrayList;
import java.util.Properties;
import java.util.Map;		// For yaml parsing storage

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.yaml.snakeyaml.Yaml;		// API for parsing YAML


public class SendEmail
{
	// map for store parsing result
	private Map< String, String > map;

	void sendToClient(String mailClient, String title, ArrayList<String[]> messageList)
	{
		String username = map.get( "HostEmailAddress" );
		String password = map.get( "HostEmailPassword" );
		String content = "\n";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", map.get( "MailSTMPHost" ) );
		props.put("mail.smtp.port", map.get( "MailSTMPPort" ) );
 
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
			
			message.setSubject(title);    // Title
			
			
			for(int i=0; i < messageList.size(); ++i){
				content = content + "Title: " + messageList.get(i)[1] + "\n" 
						    + "Time: " +  messageList.get(i)[2] + "\n" 
						    + "URL: " + messageList.get(i)[3] + "\n";
			}	
			
			message.setText(content);   //Text
 
			Transport.send(message);
 
			System.out.println("Send success");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/*
	 * Load the email sending message from "EmailData.yml",
	 * which contains the data of the host email address and password,
	 * host email setting, and the clients' email and subscribing option.
	 * The parsing result would be store in the map for futher usage.
	 */
	void loadYamlData( String yamlSourceFile )
	{
		try
		{
			// Open the yaml source file
			InputStream input = new FileInputStream( new File("src/EmailData.yml") );
			Yaml yaml = new Yaml();
			// Parsing the yaml data
			map = ( Map<String, String> )yaml.load( input );
			// Close the yaml source file
			input.close();
		}
		catch ( FileNotFoundException e )
		{
			System.out.println( "File not Found!" );
		}
		catch ( IOException e )
		{
			System.out.println( "Error when closing file" );
		}
	}	// end of loadYamlData() function
}
