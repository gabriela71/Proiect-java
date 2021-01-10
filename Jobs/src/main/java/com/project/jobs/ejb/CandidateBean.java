/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.common.CandidateDetails;
import com.project.jobs.common.CvDetails;
import com.project.jobs.entity.CV;
import com.project.jobs.entity.Candidate;
import com.project.jobs.servlet.Register;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Alex
 */
@Stateless
public class CandidateBean {

    private static final Logger LOG = Logger.getLogger(CandidateBean.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    
    
    
    public void createCandidate(String prenume, String nume, String nrTelefon, String nrMobil,String email, String username,String address,String password )
    {
       Candidate candidate = new Candidate();
       candidate.setPrenume(prenume);
       candidate.setNume(nume);
       candidate.setNrTelefon(nrTelefon);
       candidate.setNrMobil(nrMobil);
       candidate.setEmail(email);
       candidate.setUsername(username);
       candidate.setAddress(address);
       candidate.setPassword(password);
       
       em.persist(candidate);
       
       
    
    }
    
   public void addCVToCandidate (String filename, String fileType, byte[] fileContent){
        LOG.info("addCVToCandidate");
        CV cv = new CV();
        cv.setFilename(filename);
        cv.setFileType(fileType);
        cv.setFileContent(fileContent);
        
        em.persist(cv);
    }
   
    public CandidateDetails getLoggedUser(String usernameLogin) {
        LOG.info("getAllUsers");
        try {         
            TypedQuery<Candidate> typedQuery = em.createQuery("SELECT u FROM Candidate u WHERE u.username = :usernameLogin",Candidate.class).setParameter("usernameLogin", usernameLogin);
            List<Candidate> candidate=typedQuery.getResultList();
            return copyUserToDetails(candidate.get(0));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private CandidateDetails copyUserToDetails(Candidate user){
        CandidateDetails candidateDetails=new CandidateDetails(user.getId(),user.getUsername(),
        user.getNume(),user.getPrenume(),user.getNrTelefon(),user.getNrMobil(),user.getEmail(),user.getAddress(),user.getPozitiaAplicata());
        
        return candidateDetails;
    }
    
    
    public CvDetails findCvByCandidateUsername(String candidateUsername){
        TypedQuery<CV> typedQuery = em.createQuery("SELECT p FROM CV p where p.candidate.username = :username",CV.class).setParameter("username", candidateUsername);
        List<CV> cvs=typedQuery.getResultList();
        if(cvs.isEmpty()){
            return null;
        }
        CV cv=cvs.get(0);
        return new CvDetails(cv.getId(), cv.getFilename(),cv.getFileType(),cv.getFileContent());
    }
   
}

