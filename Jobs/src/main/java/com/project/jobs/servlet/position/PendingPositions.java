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
import java.util.List;
import javax.inject.Inject;
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
@ServletSecurity
        (
            value=@HttpConstraint
            (
            rolesAllowed={"DirectorGeneralRole"}
            )
            
        )
@WebServlet(name = "PendingPositions", urlPatterns = {"/PendingPositions"})
public class PendingPositions extends HttpServlet {
    
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
        
        List<PositionDetailss> positions = positionBean.getPendingPositions();
        request.setAttribute("positions", positions);
        
        request.setAttribute("language", i18n.getResourceBundle().getLocale());
        request.getRequestDispatcher("/WEB-INF/pages/pozitiiNeaprobate.jsp").forward(request, response);
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
        
        if (request.getParameter("approve") != null) {
            int positionId = Integer.parseInt(request.getParameter("approve"));            
            positionBean.aprobaPozitie(positionId);
        }
        
        if (request.getParameter("delete") != null) {
            int positionId = Integer.parseInt(request.getParameter("delete"));
            positionBean.deletePosition(positionId);
        }
        
        response.sendRedirect(request.getContextPath() + "/PendingPositions");
        
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
