/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.util.Properties;

import java.util.logging.Logger;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author houss
 */
public class EmailService {
 
    
public static void sendMail () throws Exception{

System.out.println("Preparing to send email");

Properties properties = new Properties();
properties.put("mail.smtp.auth", "true");
properties.put("mail.smtp.starttls.enable", "true");
properties.put("mail.smtp.host", "smtp.gmail.com");
properties.put("mail.smtp.port", "587");

String myAccountEmail = "xxxxx";
String password = "xxxx";

Session session = Session.getInstance(properties, new Authenticator() {

@Override
protected PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(myAccountEmail, password);
}
});
// call of the function
Message message = prepareMessage(session, myAccountEmail, myAccountEmail);
Transport.send(message);
System.out.println("Message sent successfully");
}

private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
Message message = new MimeMessage(session);

try {
message.setFrom(new InternetAddress(myAccountEmail));
message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
message.setSubject(" Confirmation d'inscription");
message.setText(" Vous êtes récemment inscrit à notre application Guide Touristique TABBAANI.\n" +
"Merci ");
} catch (Exception e) {
Logger.getLogger(EmailService.class.getName(), e.getMessage());
}
return message;
}

}

