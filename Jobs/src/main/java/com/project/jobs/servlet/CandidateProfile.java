/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.common.CandidateDetails;
import com.project.jobs.ejb.CandidateBean;
import com.project.jobs.ejb.I18n;
import com.project.jobs.ejb.LoginBean;
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
 * @author Alex
 */
@MultipartConfig
@WebServlet(name = "CandidateProfile", urlPatterns = {"/CandidateProfile"})
public class CandidateProfile extends HttpServlet {

    @Inject
    CandidateBean candidateBean;
    
    @Inject
    I18n i18n;
    
    @Inject
    LoginBean loginBean;
    

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
        
     
        CandidateDetails candidate =candidateBean.getLoggedUser(request.getRemoteUser());
        request.setAttribute("candidate", candidate);        
        
        
        request.setAttribute("language", i18n.getResourceBundle().getLocale());
        request.getRequestDispatcher("/WEB-INF/pages/candidateProfile.jsp").forward(request, response);
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
        String address = request.getParameter("address");
        
        
        CandidateDetails candidate= candidateBean.getLoggedUser(request.getRemoteUser());
        
        candidateBean.updateCandidate(candidate.getId(), nume, prenume, address, email, nrTelefon, nrMobil);
        
        
        
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String fileType = filePart.getContentType();
        long fileSize = filePart.getSize();
        byte[] fileContent = new byte[(int) fileSize];
        filePart.getInputStream().read(fileContent);
        
        candidateBean.UpdateCVCandidate(candidate.getId(), fileName, fileType, fileContent);
        
        response.sendRedirect(request.getContextPath());
        
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
