/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;


import com.project.jobs.entity.Login;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrei
 */
@Stateless
public class LoginBean {

    private static final Logger LOG = Logger.getLogger(LoginBean.class.getName());
    
    @PersistenceContext
    private EntityManager em;
    
    
    public void createEntry (String username, String password, String rol)
    {
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        login.setRol("candidat");
        
        em.persist(login);
    }
}
