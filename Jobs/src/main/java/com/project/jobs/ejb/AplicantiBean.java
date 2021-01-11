/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.entity.Aplicanti;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alex
 */
@Stateless
public class AplicantiBean {
    
    private static final Logger LOG = Logger.getLogger(CandidateBean.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    
    
}
