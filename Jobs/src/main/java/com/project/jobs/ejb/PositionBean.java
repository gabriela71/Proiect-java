/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.common.PositionDetailss;
import com.project.jobs.entity.Position;
import com.project.jobs.entity.PositionDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class PositionBean {

    private static final Logger LOG = Logger.getLogger(CandidateBean.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    public List<PositionDetailss> getAllPositions() {
        LOG.info("getAllPositions");
        try {
            List<Position> positions = (List<Position>) em.createQuery("SELECT p FROM Position p ").getResultList();
            return copyPositionToDetails(positions);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<PositionDetailss> copyPositionToDetails(List<Position> positions){
        List<PositionDetailss> detailsList=new ArrayList<>();
        for(Position position:positions){
            PositionDetailss positionDetailss=new PositionDetailss(position.getId(),
            position.getDenumire(),position.getDepartament(),position.getCerinte(),position.getResponsabilitati(),position.getBeneficii(),
            position.getNrPersoaneCautate(),position.getNrPersoaneAprobate());
            
            detailsList.add(positionDetailss);
        }
        return detailsList;
    }
    
    public List<PositionDetailss> getPendingPositions(){
        LOG.info("getPendingPositions");
        try {
            List<Position> positions = (List<Position>) em.createQuery("SELECT p FROM Position p where p.pozD.asteptare=true ").getResultList();
            return copyPositionToDetails(positions);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public List<PositionDetailss> getActivePositions(){
        LOG.info("getActivePositions");
        try {
            List<Position> positions = (List<Position>) em.createQuery("SELECT p FROM Position p where p.pozD.stare=true ").getResultList();
            return copyApprovedPositionsToDetails(positions);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    public List<PositionDetailss> getInactivePositions(){
        LOG.info("getInactivePositions");
        try {
            List<Position> positions = (List<Position>) em.createQuery("SELECT p FROM Position p where p.pozD.stare=false ").getResultList();
            return copyApprovedPositionsToDetails(positions);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<PositionDetailss> copyApprovedPositionsToDetails(List<Position> positions){
        List<PositionDetailss> detailsList=new ArrayList<>();
        for(Position position:positions){
            if(position.getPozD().getAsteptare()==false){
            PositionDetailss positionDetailss=new PositionDetailss(position.getId(),
            position.getDenumire(),position.getDepartament(),position.getCerinte(),position.getResponsabilitati(),position.getBeneficii(),
            position.getNrPersoaneCautate(),position.getNrPersoaneAprobate());
            
            detailsList.add(positionDetailss);
            }
        }
        return detailsList;
    }
    
    
    
    public void addPosition(String denumire, String departament,String cerinte,String responsabilitati,String beneficii,int nrPersoaneCautate){
        LOG.info("Create Position");
        Position position = new Position();
        position.setDenumire(denumire);
        position.setDepartament(departament);
        position.setCerinte(cerinte);
        position.setResponsabilitati(responsabilitati);
        position.setBeneficii(beneficii);
        position.setNrPersoaneCautate(nrPersoaneCautate);
        position.setNrPersoaneAprobate(0);
        
        PositionDetails positionDetails=new PositionDetails();
        positionDetails.setAsteptare(true);
        positionDetails.setStare(false);
        positionDetails.setPosition(position);
        
        position.setPozD(positionDetails);
        
        em.persist(position);
    }
    
    public PositionDetailss findById(Integer positionId){
        Position position=em.find(Position.class,positionId);
        return new PositionDetailss(position.getId(),position.getDenumire(),position.getDepartament(),
                position.getCerinte(),position.getResponsabilitati(),position.getBeneficii(),
                position.getNrPersoaneCautate(),position.getNrPersoaneAprobate());
    }
    
    public void updatePosition(int positionId, String denumire, String departament,String cerinte,String responsabilitati,String beneficii,int nrPersoaneCautate){
        
        LOG.info("updatePosition");
        
        Position position=em.find(Position.class,positionId);
        
        position.setDenumire(denumire);
        position.setDepartament(departament);
        position.setCerinte(cerinte);
        position.setResponsabilitati(responsabilitati);
        position.setBeneficii(beneficii);
        position.setNrPersoaneCautate(nrPersoaneCautate);
        
    }
    
    public void deletePosition(int positionId){
        LOG.info("deletePositionById"+positionId);
        
        Position position=em.find(Position.class, positionId);       
        em.remove(position);
        
    }
    
    public void aprobaPozitie(int positionId){
        
        Position position=em.find(Position.class,positionId);
        position.getPozD().setAsteptare(false);
        position.getPozD().setStare(true);
    }
    
    public void closePosition(int positionId){
        
        Position position=em.find(Position.class,positionId);
        position.getPozD().setStare(false);
        
    }
    
    public void setAsteptare(int positionId, boolean stare){
        Position position=em.find(Position.class,positionId);
        position.getPozD().setAsteptare(true);
    }
    
}
