/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.common.UserDetails;
import com.project.jobs.ejb.I18n;
import com.project.jobs.ejb.UserBean;
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
 * @author Gabriela
 */
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class EditUser extends HttpServlet {

    @Inject
    I18n i18n;
    
    @Inject
    private UserBean userBean;

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
        
       int userId=Integer.parseInt(request.getParameter("id"));
       UserDetails users = userBean.findById(userId);
       request.setAttribute("user", users); 
        
      request.setAttribute("language", i18n.getResourceBundle().getLocale());
      request.getRequestDispatcher("/WEB-INF/pages/editUser.jsp").forward(request, response);
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
     
        Integer userId=Integer.parseInt(request.getParameter("users_ids"));
        String nume = request.getParameter("nume");
        String prenume = request.getParameter("prenume");
        String nrTelefon = request.getParameter("nrTelefon");
        String nrMobil = request.getParameter("nrMobil");
        String email = request.getParameter("email");
        String pozitie = request.getParameter("pozitie");
        
        userBean.updateUser(userId,nume, prenume,nrTelefon, nrMobil, email, pozitie);
        
        response.sendRedirect(request.getContextPath()+"/User");
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
