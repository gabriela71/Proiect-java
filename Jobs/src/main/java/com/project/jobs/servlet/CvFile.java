/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.servlet;

import com.project.jobs.common.AplicantDetails;
import com.project.jobs.common.CandidateDetails;
import com.project.jobs.common.CvDetails;
import com.project.jobs.ejb.ApplicantBean;
import com.project.jobs.ejb.CandidateBean;
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
@WebServlet(name = "CvFile", urlPatterns = {"/CvFile"})
public class CvFile extends HttpServlet {

    @Inject
    CandidateBean candidateBean;
    @Inject
    ApplicantBean applicantBean;

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
        
        int id_aplicant=Integer.parseInt(request.getParameter("id"));
        
        AplicantDetails aplicant = applicantBean.findById(id_aplicant);
        int id_candidat=applicantBean.getCandidateId(id_aplicant);
        CandidateDetails candidat = candidateBean.findById(id_candidat);
            
        CvDetails cv = candidateBean.findCvByCandidateUsername(candidat.getUsername());
        
        if(cv!=null)
        {
        response.setContentType(cv.getFileType());
        response.setContentLength(cv.getFileContent().length);
        response.getOutputStream().write(cv.getFileContent());
        }else{
        response.sendError(HttpServletResponse.SC_NOT_FOUND);  //404
        }
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
