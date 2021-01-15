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
import java.util.ArrayList;
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
    
   public void addCVToCandidate (int candidate_id,String filename, String fileType, byte[] fileContent){
        LOG.info("addCVToCandidate");
        CV cv = new CV();
        cv.setFilename(filename);
        cv.setFileType(fileType);
        cv.setFileContent(fileContent);
        
        Candidate candidate= em.find(Candidate.class,candidate_id);
        candidate.setCv(cv);
        cv.setCandidate(candidate);
        
        em.persist(cv);
    }
   
   public void UpdateCVCandidate(int candidate_id,String filename,String fileType,byte[] fileContent){
       LOG.info("updateCv");
       
       Candidate candidate=em.find(Candidate.class, candidate_id);
       
       CV cv=candidate.getCv();
       cv.setFilename(filename);
       cv.setFileType(fileType);
       cv.setFileContent(fileContent);
       
   }
   
   public void DeleteCVCandidate(int candidate_id){
       LOG.info("deleteCv");
       
       Candidate candidate=em.find(Candidate.class, candidate_id);
       
       CV cv=candidate.getCv();
    //   cv.setFilename(filename);
    //   cv.setFileType(fileType);
    //   cv.setFileContent(fileContent);
       
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
        user.getNume(),user.getPrenume(),user.getNrTelefon(),user.getNrMobil(),user.getEmail(),user.getAddress());
        
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
    
    public void updateCandidate(int candidate_id,String nume,String prenume,String adress,String email,String nrTelefon,String nrMobil){
        
        Candidate candidate = em.find(Candidate.class, candidate_id);
        candidate.setAddress(adress);
        candidate.setEmail(email);
        candidate.setNrMobil(nrMobil);
        candidate.setNrTelefon(nrTelefon);
        candidate.setNume(nume);
        candidate.setPrenume(prenume);
        
    }
   
    
    
        public List<CandidateDetails> getAllCandidates() {
        LOG.info("getAllCandidates");
        try {
            List<Candidate> candidate = (List<Candidate>) em.createQuery("SELECT u FROM Candidate u").getResultList();
            return copyCandidatesToDetails(candidate);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
        
        
        
        private List<CandidateDetails> copyCandidatesToDetails(List<Candidate> candidat) {
        List<CandidateDetails> detailsList = new ArrayList<>();
        for (Candidate candidate : candidat) {
            CandidateDetails candidateDetails = new CandidateDetails(candidate.getId(),
                    candidate.getUsername(),
                    candidate.getNume(),
                    candidate.getPrenume(),
                    candidate.getNrTelefon(),
                    candidate.getNrMobil(),
                    candidate.getEmail(),
                    candidate.getAddress());
            detailsList.add(candidateDetails);
        }
        return detailsList;
    }
            
            
    public CandidateDetails findById(Integer candidateId){
        Candidate candidate=em.find(Candidate.class,candidateId);
        return new CandidateDetails(candidate.getId(),candidate.getUsername(),
                candidate.getNume(),candidate.getPrenume(),candidate.getNrTelefon(),
                candidate.getNrMobil(),candidate.getEmail(),candidate.getAddress());
    }
    
    //STERGE CANDIDAT DUPA ID
    public void deleteCandidateById(Integer id) {
        
        LOG.info("deleteCandidateById");
        
        Candidate candidate = em.find(Candidate.class,id);
        em.remove(candidate);
        
    }
}

