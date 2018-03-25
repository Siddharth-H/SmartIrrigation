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
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
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

public class SendReport {

    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "destinationemail@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "smartirrigation.cs@gmail.com";

        final String username = "smartirrigation.cs@gmail.com";//change accordingly
        final String password = "smartirrigation2018";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Report: "+Common.TODAY);

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("Daily Analysis Report");

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "c:/reports_smart_irrigation/report.pdf";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

//import java.util.*;
//import javax.mail.*;
//import javax.mail.internet.*;
//import javax.activation.*;
//
//class SendReport {
//
//    public static void main(String[] args) {
//
//        String to = "purvi.pahadiya.7@gmail.com";//change accordingly  
//        final String user = "smartirrigation.cs@gmail.com";//change accordingly  
//        final String password = "smartirrigation2018";//change accordingly  
//
//        //1) get the session object     
//        Properties properties = System.getProperties();
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.user", user);
//        properties.put("mail.smtp.password", password);
//        properties.put("mail.smtp.port", "587");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");;
//
////        Session session = Session.getDefaultInstance(properties,
////                new javax.mail.Authenticator() {
////            protected PasswordAuthentication getPasswordAuthentication() {
////                return new PasswordAuthentication(user, password);
////            }
////        });
//        Session session = Session.getDefaultInstance(properties);
//
//        //2) compose message     
//        try {
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(user));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//            message.setSubject("Message Aleart");
//
//            //3) create MimeBodyPart object and set your message text     
//            BodyPart messageBodyPart1 = new MimeBodyPart();
//            messageBodyPart1.setText("This is message body");
//
//            //4) create new MimeBodyPart object and set DataHandler object to this object      
//            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//
//            String filename = "C:\\reports_smart_irrigation\report.pdf";//change accordingly  
//            DataSource source = new FileDataSource(filename);
//            messageBodyPart2.setDataHandler(new DataHandler(source));
//            messageBodyPart2.setFileName(filename);
//
//            //5) create Multipart object and add MimeBodyPart objects to this object      
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart1);
//            multipart.addBodyPart(messageBodyPart2);
//
//            //6) set the multiplart object to the message object  
//            message.setContent(multipart);
//
//            //7) send message  
////            Transport.send(message);
//            Transport transport = session.getTransport("smtp");
//            transport.connect("smtp.gmail.com", user, password);
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();
//            System.out.println("Sent message successfully....");
//            System.out.println("message sent....");
//        } catch (MessagingException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
