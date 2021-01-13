/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.ejb.CandidateBean;
import com.project.jobs.ejb.I18n;
import com.project.jobs.ejb.LoginBean;
import com.project.jobs.util.PasswordUtil;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Andrei
 */
@MultipartConfig
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {
    
    @Inject
    CandidateBean candidateBean;
    @Inject
    LoginBean loginBean;
    @Inject
    I18n i18n;

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
        
        
        request.setAttribute("language", i18n.getResourceBundle().getLocale());
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
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
        
        String prenume = request.getParameter("prenume");
        String nume = request.getParameter("nume");
        String nrTelefon = request.getParameter("nrTelefon");
        String nrMobil = request.getParameter("nrMobil");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String rol = request.getParameter("rol");
        
        String passwordSha256=PasswordUtil.convertToSha256(password);
        
        candidateBean.createCandidate(prenume, nume, nrTelefon, nrMobil, email, username, address, passwordSha256);
        loginBean.createEntry(username, passwordSha256, rol);
        
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);
        
        candidateBean.addCVToCandidate(candidateBean.getLoggedUser(username).getId(),fileName, fileType, fileContent);
        
        response.sendRedirect(request.getContextPath() + "/Login");
        
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
