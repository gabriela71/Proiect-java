/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import java.util.Properties;
import javax.ejb.Stateless;
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

/**
 *
 * @author Alex
 */
@Stateless
public class EmailBean {
   
    String to = "jobsrecruiting.project@gmail.com"; //loggedCandidate.getEmail();

    // Sender's email ID needs to be mentioned
    String from = "jobsrecruiting.project@gmail.com";

    // Assuming you are sending email from through gmails smtp
    String host = "smtp.gmail.com";
    
    public void sendEmail(){
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server     
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("jobsrecruiting.project@gmail.com", "recruitingjobs157A");

            }

        });
        session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Aplicare pozitie");

            // Now set the actual message
            //message.setText(loggedCandidate.getNume()+" "+loggedCandidate.getPrenume()+" a aplicat pentru o functie");
            Multipart multipart = new MimeMultipart();
            //MimeBodyPart attachmentPart = new MimeBodyPart();
            MimeBodyPart textPart = new MimeBodyPart();

//            byte[] bytes = cv.getFileContent();
//
//            try {
//                File f = new File(cv.getFilename() + ".pdf"); //eroare
//                try (FileOutputStream fos = new FileOutputStream(f)) {
//                    fos.write(bytes);
//                    fos.flush();
//                } catch (IOException i) {
//                    //eroare
//                }
//                attachmentPart.attachFile(f);
//            } catch (IOException e) {
//                //eroare
//            }


            textPart.setText("Text de proba");

            //multipart.addBodyPart(attachmentPart);
            multipart.addBodyPart(textPart);

            message.setContent(multipart);

            Transport.send(message);

        } catch (MessagingException mex) {
        }
    }
}
