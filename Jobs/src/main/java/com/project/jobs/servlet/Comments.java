/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.common.CandidateDetails;
import com.project.jobs.common.PositionDetailss;
import com.project.jobs.common.UserDetails;
import com.project.jobs.ejb.CandidateBean;
import com.project.jobs.ejb.I18n;
import com.project.jobs.ejb.PositionBean;
import com.project.jobs.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;
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
 * @author Andrei
 */
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {"PositionRole"}
        )
)
@WebServlet(name = "Comments", urlPatterns = {"/Comments"})
public class Comments extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CandidateBean.class.getName());
    @Inject
    PositionBean positionBean;
    @Inject
    UserBean userBean;
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
        List<PositionDetailss> positions = positionBean.getActivePositions();
        UserDetails loggedUser = userBean.getLoggedUser(request.getRemoteUser());
        request.setAttribute("positions", positions);
        request.setAttribute("user", loggedUser);
        request.getRequestDispatcher("/WEB-INF/pages/commentsPosition.jsp").forward(request, response);
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
