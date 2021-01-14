/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.common.AplicantDetails;
import com.project.jobs.ejb.ApplicantBean;
import com.project.jobs.ejb.I18n;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Applicants", urlPatterns = {"/Applicants"})
public class Applicants extends HttpServlet {

    @Inject
    private ApplicantBean aplicantBean;
     
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
        request.setAttribute("activePage", "Applicants");
        
        List<AplicantDetails> aplicanti= aplicantBean.getAllApplicants(1);
        request.setAttribute("aplicanti", aplicanti);
        
        request.setAttribute("language", i18n.getResourceBundle().getLocale());
        request.getRequestDispatcher("/WEB-INF/pages/applicants.jsp").forward(request, response);
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
        
       String[] aplicantIdsAsString= request.getParameterValues("aplicant_ids");
        
        if(aplicantIdsAsString != null)
        {
            List<Integer> aplicantIds= new ArrayList<>();
            
            for(String aplicantIdAsString: aplicantIdsAsString)
            {
                aplicantIds.add(Integer.parseInt(aplicantIdAsString));
            }
            
            aplicantBean.deleteApplicantsByIds(aplicantIds);
        }
       
        response.sendRedirect(request.getContextPath()+ "/Applicants");
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
