/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.entity.Candidate;
import com.project.jobs.entity.Position;
import com.project.jobs.entity.PositionComments;
import com.project.jobs.entity.User;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrei
 */
@Stateless
public class CommentsPositionBean {

    private static final Logger LOG = Logger.getLogger(CommentsPositionBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public void createCommentsPosition(Integer id_pozitie, Integer id_user, String comentariu) {
        PositionComments positionComments = new PositionComments();

        positionComments.setComentariu(comentariu);
        User user = em.find(User.class, id_user);
        positionComments.setUser(user);
        Position position = em.find(Position.class, id_pozitie);
        positionComments.setPosition(position);
        em.persist(positionComments);
    }
}
