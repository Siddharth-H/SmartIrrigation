/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package majorproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author dev
 */
public class JMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter reciepeint ");
//        String to = sc.next();
//        System.out.println("Enter cc ");
//        String cc = sc.next();
//        System.out.println("Enter bcc ");
//        String bcc = sc.next();
//        System.out.println("Enter Subject ");
//        String subject = sc.next();
//        System.out.println("Enter message ");
//        String content = sc.next();
////        String to = "rajupushpad311@gmail.com";
////        String cc = "divya25sen@gmail.com";
////        String subject = "Invitation";
////        String content = "Hello... ";
//        JMail m = new JMail();
//        m.sendMail(to, cc, bcc, subject, content);

        sendMail("purvi.pahadiya.7@gmail.com", "barkha.pahadiya@gmail.com", "", "Test thru Java", "Yes Working");

    }

    public static synchronized int sendMail(String to,
            String cc, String bcc, String subject, String content) {
//        return sendMailOneDataIndex(to, cc, bcc, subject, content, "noreply@beta.onedataindex.in", "dits1hkd");
        return sendMailGmail(to, cc, bcc, subject, content, "barkha.pahadiya@gmail.com", "purvijain");

    }

    // Although in most cases this should work with Gmail
    // But still Gmail needs to varify for a new device 
    // Get help from following page
    // https://stackoverflow.com/questions/25341198/javax-mail-authenticationfailedexception-is-thrown-while-sending-email-in-java 
    //
    public static synchronized int sendMailGmail(String to, String cc, String bcc,
            String subject, String content, String emailID, String password) {

        try {
            Properties props = System.getProperties();
            // -- Attaching to default Session, or we could start a new one --
            // TODO make following properties to pick from properties file.
//            props.put("mail.transport.protocol", "smtp");
//            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
//            SMTPAuthenticator auth = new SMTPAuthenticator();

            //get Session   
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication("peterrrrr.parker@gmail.com", "superrrrman");
                    return new PasswordAuthentication(emailID, password);
                }
            });
//            Session session = Session.getInstance(props, auth);
            // -- Create a new message --
            MimeMessage msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(emailID));

            if (!(to == null || "".equals(to))) {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }
            if (!(cc == null || "".equals(cc))) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            }
            if (!(bcc == null || "".equals(bcc))) {
                msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            }
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
//            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc, false));
//            msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(bcc, false));
            msg.setSubject(subject);
//            msg.setContent(content,"text/html");
            msg.setText(content);
//            // -- Set some other header information --
//            msg.setHeader("MyMail", "Mr. XYZ");
//            msg.setSentDate(new Date());
            // -- Send the message --
            Transport.send(msg);
            System.out.println("Message sent to" + to + " OK.");
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception " + ex);
            return -1;
        }
    }

    // Although in most cases this should work with Gmail
    // But still Gmail needs to varify for a new device 
    // Get help from following page
    // https://stackoverflow.com/questions/25341198/javax-mail-authenticationfailedexception-is-thrown-while-sending-email-in-java 
    //
    public static synchronized int sendMailOneDataIndex(String to, String cc, String bcc,
            String subject, String content, String emailID, String password) {

        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "onedataindex.in");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailID, password);
                }
            });

            // -- Create a new message --
            MimeMessage msg = new MimeMessage(session);
            // -- Set the FROM and TO fields --
            msg.setFrom(new InternetAddress(emailID));

            if (!(to == null || "".equals(to))) {
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }
            if (!(cc == null || "".equals(cc))) {
                msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            }
            if (!(bcc == null || "".equals(bcc))) {
                msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            }
            msg.setSubject(subject);
//            msg.setContent(content,"text/html");
            msg.setText(content);

            // -- Send the message --
            Transport.send(msg);
            System.out.println("Message sent to" + to + " OK.");
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

//    private static class SMTPAuthenticator extends javax.mail.Authenticator {
//
//        @Override
//        public javax.mail.PasswordAuthentication getPasswordAuthentication() {
//            String username = "peterrrrr.parker@gmail.com";           // specify your email id here (sender's email id)
//            String password = "superrrrman";                                      // specify your password here
//            return new javax.mail.PasswordAuthentication(username, password);
//        }
//    }
}
