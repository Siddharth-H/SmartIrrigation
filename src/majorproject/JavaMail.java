/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject;

/**
 *
 * @author Purvi
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class JavaMail {

    public static void main(String[] args) {
        int status = sendMail("purvi.pahadiya.7@gmail.com","Subejct", "Content");
    }

    public static int sendMail(String to, String subject, String content) {
        // Sender's email ID needs to be mentioned
        String from = "smartirrigation.cs@gmail.com";
//        String from = "barkha.pahadiya@gmail.com";
        String pass = "smartirrigation2018";
//        String pass = "purvijain";
        // Recipient's email ID needs to be mentioned.
//        String to = "purvi.pahadiya.7@gmail.com";

        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", pass);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject( subject);

            // Now set the actual message
            message.setText(content);

            // Send message
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("Sent message successfully....");
            return 1;
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return 0;
        }
    }
}
