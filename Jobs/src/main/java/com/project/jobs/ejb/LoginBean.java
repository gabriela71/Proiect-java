/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.entity.Login;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Andrei
 */
@Stateless
public class LoginBean {

    @PersistenceContext
    private EntityManager em;

    public void createEntry(String username, String password, String rol) {
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        login.setRol(rol);

        em.persist(login);
    }

    public void deleteEntryByUsername(String username) {
        try {
            TypedQuery<Login> typedQuery = em.createQuery("SELECT u FROM Login u WHERE u.username = :usernameLogin", Login.class).setParameter("usernameLogin", username);
            List<Login> login = typedQuery.getResultList();
            Login loginEntry = login.get(0);
            em.remove(loginEntry);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }

    }

}
