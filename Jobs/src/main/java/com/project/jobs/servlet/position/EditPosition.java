/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet.position;

import com.project.jobs.common.PositionDetailss;
import com.project.jobs.ejb.I18n;
import com.project.jobs.ejb.PositionBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alex
 */
@WebServlet(name = "EditPosition", urlPatterns = {"/Position/Update"})
public class EditPosition extends HttpServlet {

    @Inject
    PositionBean positionBean;
    
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
        
        int positionId=Integer.parseInt(request.getParameter("id"));
        PositionDetailss position =positionBean.findById(positionId);
        request.setAttribute("position", position);        
        request.setAttribute("pagina", request.getParameter("pagina"));
        
        request.setAttribute("language", i18n.getResourceBundle().getLocale());
        request.getRequestDispatcher("/WEB-INF/pages/editPosition.jsp").forward(request, response);
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
        
        String denumire=request.getParameter("denumire");
        String departament=request.getParameter("departament");
        String cerinte=request.getParameter("cerinte");
        String responsabilitati=request.getParameter("responsabilitati");
        String beneficii=request.getParameter("beneficii");
        int nrPersoaneCautate=Integer.parseInt(request.getParameter("nrPersoaneCautate"));
        int positionId=Integer.parseInt(request.getParameter("position_id"));
        
        positionBean.updatePosition(positionId, denumire, departament, cerinte, responsabilitati, beneficii, nrPersoaneCautate);
        
        response.sendRedirect(request.getContextPath()+"/"+request.getParameter("nume_pagina"));
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
