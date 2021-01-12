/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.common.UserDetails;
import com.project.jobs.entity.User;
import java.util.List;
import java.util.logging.Logger;
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
public class UserBean {

    private static final Logger LOG = Logger.getLogger(CandidateBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public UserDetails getLoggedUser(String usernameLogin) {
        LOG.info("getAllUsers");
        try {
            TypedQuery<User> typedQuery = em.createQuery("SELECT u FROM User u WHERE u.username = :usernameLogin", User.class).setParameter("usernameLogin", usernameLogin);
            List<User> user = typedQuery.getResultList();
            return copyUserToDetails(user.get(0));
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private UserDetails copyUserToDetails(User user) {
        UserDetails userDetails = new UserDetails(user.getId(), user.getNume(),
                user.getPrenume(), user.getNrTelefon(), user.getNrMobil(), user.getEmail(), user.getPozitie(), user.getUsername());

        return userDetails;

    }
    

}
