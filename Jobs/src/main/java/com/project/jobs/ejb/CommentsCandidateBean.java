/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.ejb;

import com.project.jobs.entity.Candidate;
import com.project.jobs.entity.CandidateComments;
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
public class CommentsCandidateBean {
    private static final Logger LOG = Logger.getLogger(CommentsPositionBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public void createCommentsCandidate(Integer id_candidate, Integer id_user, String comentariu) {
        CandidateComments candidateComments = new CandidateComments();

        candidateComments.setComentariu(comentariu);
        User user = em.find(User.class, id_user);
        candidateComments.setUser(user);
        Candidate candidate = em.find(Candidate.class, id_candidate);
        candidateComments.setCandidate(candidate);
        em.persist(candidateComments);
    }
}
