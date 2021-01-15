/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.common.AplicantDetails;
import com.project.jobs.entity.Aplicanti;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
    
    //APLICANTI
    public List<AplicantDetails> getAllApplicants(int caz) 
    {
        LOG.info("getAllApplicants");
        try 
        {
            List<Aplicanti> aplicanti = (List<Aplicanti>) em.createQuery("SELECT a FROM Aplicanti a ").getResultList();
            return copyAplicantiToDetails(aplicanti, caz);
        } 
        catch (Exception ex) 
        {
            throw new EJBException(ex);
        }
    }
    
    //DECIDE CE FEL DE CANDIDATI SUNT DORITI
    private List<AplicantDetails> copyAplicantiToDetails(List<Aplicanti> aplicanti, int caz)
    {
        List<AplicantDetails> detailsList= new ArrayList<>();
        for(Aplicanti aplicant :aplicanti)
        {
            switch(caz)
            {
                case 1:
                    if(aplicant.getPropus()==0 && aplicant.getAles()==0)
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
                    break;
                case 2:
                    if(aplicant.getPropus()==1 && aplicant.getAles()==0)
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
                    break;
                case 3:
                    if(aplicant.getPropus()==1 && aplicant.getAles()==1)
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
                    break;
            }
        }
        return detailsList;
    }
    
    //GASESTE CANDIDAT DUPA ID
    public AplicantDetails findById(Integer aplicantId)
    {
        Aplicanti aplicant = em.find(Aplicanti.class, aplicantId);
        return new AplicantDetails(aplicant.getCandidate().getId(),
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
    }
    
    //ADAUGA DATA INTERVIU
    public void addDataInterviu(Integer aplicantId, Date dataInterviu) 
    {
        LOG.info("addDataInterviu");
        
        Aplicanti aplicant = em.find(Aplicanti.class, aplicantId);
        aplicant.setDataInterviu(dataInterviu);
        aplicant.setPropus(1);
       // em.persist(aplicant);
    }
    
    //STERGE CANDIDATI DUPA ID
    public void deleteApplicantsByIds(Collection <Integer> ids) {
        
        LOG.info("deleteApplicantsByIds");
        
        for(Integer id : ids)
        {
            Aplicanti aplicant = em.find(Aplicanti.class,id);
            em.remove(aplicant);
        }
    }
    
    //SETEAZA CA ALES
    public void setElected(Integer aplicantId) 
    {
        LOG.info("setElected");
        
        Aplicanti aplicant = em.find(Aplicanti.class, aplicantId);
        aplicant.setAles(1);
        //em.persist(aplicant);
    }
    
    //ANULATI PROPUNEREA
    public void undoProposition(Integer aplicantId) 
    {
        LOG.info("undoProposition");
        
        Aplicanti aplicant = em.find(Aplicanti.class, aplicantId);
        aplicant.setPropus(0);
        aplicant.setDataInterviu(null);
        //em.persist(aplicant);
    }
}
