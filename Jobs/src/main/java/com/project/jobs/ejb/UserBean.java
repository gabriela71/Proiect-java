/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.common.UserDetails;
import com.project.jobs.entity.User;
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
    
    public void createUser( String nume, String prenume,  String nrTelefon,  String nrMobil,  String email, String pozitie, String username, String password)
    {
        LOG.info("createUser");
        User user= new User();
        
        user.setNume(nume);
        user.setPrenume(prenume);
        user.setNrTelefon(nrTelefon);
        user.setNrMobil(nrMobil);
        user.setEmail(email);
        user.setPozitie(pozitie);
        user.setUsername(username);
        user.setPassword(password);
        
        em.persist(user);
    }

    //UTILIZATORI
    public List<UserDetails> getAllUsers() 
    {
        LOG.info("getAllUsers");
        try 
        {
            List<User> users = (List<User>) em.createQuery("SELECT u FROM User u ").getResultList();
            return copyUsersToDetails(users);
        } 
        catch (Exception ex) 
        {
            throw new EJBException(ex);
        }
    }
    
    //COPIARE IN DETALII
    private List<UserDetails> copyUsersToDetails(List<User> users)
    {
        List<UserDetails> detailsList= new ArrayList<>();
        for(User user :users)
        {
            UserDetails userDetails= new UserDetails(user.getId(),
                    user.getNume(),
                    user.getPrenume(), 
                    user.getNrTelefon(),
                    user.getNrMobil(),
                    user.getEmail(),
                    user.getPozitie(),
                    user.getUsername());
            detailsList.add(userDetails);
        }
         
        return detailsList;
    }
}
