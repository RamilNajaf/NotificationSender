package UTIL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;    
public class MailUtil{  
    public static void send(String from,String password,String to,String sub,String msg) throws MessagingException{  
 
    	
    	
    	
    	
    	    Properties props = new Properties();
    	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    	    props.put("mail.smtp.host", "smtp.gmail.com");
    	    props.put("mail.from", from);
    	    props.put("mail.smtp.starttls.enable", "true");
    	    props.put("mail.smtp.port", "587");
    	    props.setProperty("mail.debug", "true");

    	    Session session = Session.getInstance(props, null);
    	    session.getProperties().put("mail.smtp.ssl.trust", "smtp.gmail.com");
    	    
    	    MimeMessage msg1 = new MimeMessage(session);

    	    msg1.setRecipients(Message.RecipientType.TO, to);
    	    msg1.setSubject(sub);
    	    msg1.setSentDate(Date.valueOf(LocalDate.now()));
    	    msg1.setText(msg);

    	    Transport transport = session.getTransport("smtp");

    	    transport.connect(from, password);
    	    transport.sendMessage(msg1, msg1.getAllRecipients());
    	    transport.close();  
             
    }  
}  
