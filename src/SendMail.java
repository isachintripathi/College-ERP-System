/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Abhishek Walavalkar
 */
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {

    public static void sendMail(String address, String subject, String message) {
        try {
            String from = "abhiwalavalkar15@gmail.com";
            String pass = "xP@11WIND12";
            String to = address;
            String host = "smtp.gmail.com";

            Properties prop = System.getProperties();
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.user", from);
            prop.put("mail.smtp.password", pass);
            prop.put("mail.smtp.port", "587");
            prop.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(prop);
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress toaddress = new InternetAddress(to);

            msg.setRecipient(Message.RecipientType.TO, toaddress);


            msg.setSubject(subject);
            msg.setContent(message, "text/html; charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

