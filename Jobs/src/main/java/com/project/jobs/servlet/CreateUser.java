/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.common.AplicantDetails;
import com.project.jobs.ejb.ApplicantBean;
import com.project.jobs.ejb.CandidateBean;
import com.project.jobs.ejb.I18n;
import com.project.jobs.ejb.LoginBean;
import com.project.jobs.ejb.UserBean;
import com.project.jobs.util.PasswordUtil;
import com.project.jobs.util.UsernameUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stefi
 */
@WebServlet(name = "CreateUser", urlPatterns = {"/CreateUser"})
public class CreateUser extends HttpServlet {

    @Inject
    private ApplicantBean aplicantBean;
    
    @Inject
    private UserBean userBean;
    
    @Inject
    private LoginBean loginBean;
    
    @Inject
    private CandidateBean candidateBean;
     
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
        
        int aplicantId=Integer.parseInt(request.getParameter("id"));
        AplicantDetails aplicant = aplicantBean.findById(aplicantId);
        request.setAttribute("aplicant", aplicant);
        
        String username=UsernameUtil.createUsername(aplicant.getNume(), aplicant.getPrenume());
        
        request.setAttribute("language", i18n.getResourceBundle().getLocale());
        request.getRequestDispatcher("/WEB-INF/pages/suggest.jsp").forward(request, response);
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
        
        String nume= request.getParameter("nume");
        String prenume= request.getParameter("prenume");
        String nrTelefon= request.getParameter("phone");
        String nrMobil= request.getParameter("mobile");
        String email= request.getParameter("email");
        String pozitie= request.getParameter("positionName");
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String rol= request.getParameter("rol");
        int aplicantId= Integer.parseInt(request.getParameter("aplicant_id"));
        
        String passwordSha256=PasswordUtil.convertToSha256(password);
        
        userBean.createUser(nume, prenume, nrTelefon, nrMobil, email, pozitie, username, passwordSha256);
        
        loginBean.createEntry(username, passwordSha256, rol);
        
        candidateBean.deleteCandidateById(aplicantId);
        
        
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
