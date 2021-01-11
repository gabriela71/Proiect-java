/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.sendemail;

import com.project.jobs.ejb.CandidateBean;
import com.project.jobs.ejb.EmailBean;
import java.io.IOException;
import java.util.Properties;
import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */


@WebServlet(name = "Jobs", urlPatterns = {"/Jobs"})
public class Jobs extends HttpServlet {

    @Inject
    CandidateBean candidateBean;
    
    @Inject
    EmailBean emailBean;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/pages/jobs.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 //               CandidateDetails loggedCandidate=candidateBean.getLoggedUser("test.gmail");
        //CvDetails cv = candidateBean.findCvByCandidateUsername("test");
        // Recipient's email ID needs to be mentioned.
        String to = "jobsrecruiting.project@gmail.com"; //loggedCandidate.getEmail();

        // Sender's email ID needs to be mentioned
        String from = "jobsrecruiting.project@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

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
        session.setDebug(true); //debug
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

        //emailBean.sendEmail();

        response.sendRedirect(request.getContextPath() + "/Jobs");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
