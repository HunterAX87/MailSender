package org.example;

import javax.mail.*;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {


        String from = "abduxalikovxudoyor@gmail.com";
        String to = "abduxalikovxudoyor@gmail.com";
        String host= "smtp.gmail.com";
        String smtpPort= "465";

        Properties properties= new Properties();
        properties.put ("mail.smtp.host", host);
        properties.put ("mail.smtp.port", smtpPort);
        properties.put ("mail.smtp.ssl.enable", "true");
        properties.put ("mail.smtp.auth", "true");

        Session session= Session.getInstance( properties,
        new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,"izgbodehliblqdew");
            }
        }
);
        //Session session= Session.getInstance(



        session.setDebug(true);
        try{
            MimeMessage message= new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("09-152, Абдухаликов Худоёр");
            String msg= "04.03.2023, Втоорник, Солнечно- без осадков";
            message.setText("msg");



            MimeBodyPart mimeBodyPart= new MimeBodyPart();
            mimeBodyPart.setContent(msg,"text/html; charset=utf-8");

            Multipart multipart= new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            multipart.addBodyPart(Main.addFile("C:\\\\A\\\\Pretty.jpg"));
            multipart.addBodyPart(Main.addFile("C:\\\\A\\\\main.java"));
            multipart.addBodyPart(Main.addFile("C:\\Users\\Asus\\IdeaProjects\\MailSender\\pom.xml"));
            message.setContent(multipart);
            Transport.send(message);

        } catch (Exception e){
            e.printStackTrace();
        }

    }
    public static MimeBodyPart addFile(String path) throws MessagingException, IOException {
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.attachFile(path);
        return mimeBodyPart;
    }
}