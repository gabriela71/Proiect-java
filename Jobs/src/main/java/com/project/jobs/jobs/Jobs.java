/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.jobs;

import com.project.jobs.common.PositionDetailss;
import com.project.jobs.ejb.AplicantiBean;
import com.project.jobs.ejb.CandidateBean;
import com.project.jobs.ejb.PositionBean;
import com.project.sendemail.SendEmail;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "Jobs", urlPatterns = {"/Jobs"})
public class Jobs extends HttpServlet {

    @Inject
    CandidateBean candidateBean;
    
    
    @Inject
    AplicantiBean aplicantiBean;
    
    @Inject
    PositionBean positionBean;

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

        List<PositionDetailss> positions=positionBean.getActivePositions();
        request.setAttribute("positions", positions);
        request.getRequestDispatcher("/WEB-INF/pages/jobs.jsp").forward(request, response);
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
        
        //CandidateDetails loggedCandidate=candidateBean.getLoggedUser("test.gmail");
        //CvDetails cv = candidateBean.findCvByCandidateUsername("test");

        //int positionId=Integer.parseInt(request.getParameter("position_id"));
        //int aplicantId=loggedCandidate.getId();
        //aplicantiBean.addAplicant(aplicantId, positionId);
        
        SendEmail send=new SendEmail();
        send.sendEmail();
        
        response.sendRedirect(request.getContextPath() + "/Jobs");
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