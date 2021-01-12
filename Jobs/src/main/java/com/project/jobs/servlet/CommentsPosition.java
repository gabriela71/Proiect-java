/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.common.PositionDetailss;
import com.project.jobs.common.UserDetails;
import com.project.jobs.ejb.CommentsPositionBean;
import com.project.jobs.ejb.PositionBean;
import com.project.jobs.ejb.UserBean;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.log;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrei
 */
@WebServlet(name = "CommentsPosition", urlPatterns = {"/CommentsPosition"})
public class CommentsPosition extends HttpServlet {

    @Inject
    CommentsPositionBean commentsPositionBean;
    @Inject
    UserBean userBean;
    @Inject
    PositionBean positionBean;
     private static final Logger LOG = Logger.getLogger(CommentsPositionBean.class.getName());

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

        int id_pozitie = Integer.parseInt(request.getParameter("id_pozitie"));
        PositionDetailss positionDetailss = positionBean.findById(id_pozitie);
        UserDetails userDetails = userBean.getLoggedUser(request.getRemoteUser());
        request.setAttribute("position", positionDetailss);
        request.setAttribute("user", userDetails);
        request.getRequestDispatcher("/WEB-INF/pages/addCommentsPosition.jsp").forward(request, response);
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

        int id_pozitie = Integer.parseInt(request.getParameter("position_id"));
        int id_user = Integer.parseInt(request.getParameter("user_id"));
        String comentariu = request.getParameter("comentariu");
        commentsPositionBean.createCommentsPosition(id_pozitie, id_user, comentariu);
        response.sendRedirect(request.getContextPath() + "/Comments");
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
