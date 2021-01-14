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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Suggest", urlPatterns = {"/Suggest"})
public class Suggest extends HttpServlet {

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
        
        int aplicantId=Integer.parseInt(request.getParameter("id"));
        AplicantDetails aplicant = aplicantBean.findById(aplicantId);
        request.setAttribute("aplicant", aplicant);
        
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
        String data=request.getParameter("dataInterviu");
        Integer aplicandtId=Integer.parseInt(request.getParameter("aplicant_id"));
        try {
            
            Date dataInterviu = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            aplicantBean.addDataInterviu(aplicandtId,dataInterviu);
            
            response.sendRedirect(request.getContextPath()+"/Applicants");
        } catch (ParseException ex) {
            Logger.getLogger(Suggest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
