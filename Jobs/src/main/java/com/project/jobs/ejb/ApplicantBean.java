/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.common.AplicantDetails;
import com.project.jobs.entity.Aplicanti;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ejb.EJBException;

/**
 *
 * @author stefi
 */
@Stateless
public class ApplicantBean {

    private static final Logger LOG = Logger.getLogger(ApplicantBean.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    public List<AplicantDetails> getAllApplicants() 
    {
        LOG.info("getAllApplicants");
        try 
        {
            List<Aplicanti> aplicanti = (List<Aplicanti>) em.createQuery("SELECT a FROM Aplicanti a ").getResultList();
           // List<Candidate> candidate = (List<Candidate>) em.createQuery("SELECT c FROM Car c").getResultList();
            return copyAplicantiToDetails(aplicanti);
        } 
        catch (Exception ex) 
        {
            throw new EJBException(ex);
        }
    }
    
    private List<AplicantDetails> copyAplicantiToDetails(List<Aplicanti> aplicanti){
        List<AplicantDetails> detailsList= new ArrayList<>();
        for(Aplicanti aplicant :aplicanti)
        {
            AplicantDetails aplicantDetails=new AplicantDetails(aplicant.getCandidate().getId(),
                    aplicant.getCandidate().getNume(),
                    aplicant.getCandidate().getPrenume(),
                    aplicant.getCandidate().getNrTelefon(),
                    aplicant.getCandidate().getNrMobil(),
                    aplicant.getCandidate().getEmail(),
                    aplicant.getConfirmat(),
                    aplicant.getDataInterviu(),
                    aplicant.getPropus(),
                    aplicant.getAles(),
                    aplicant.getPosition().getDenumire(),
                    aplicant.getPosition().getDepartament());
            detailsList.add(aplicantDetails);
        }
        return detailsList;
    }
}
