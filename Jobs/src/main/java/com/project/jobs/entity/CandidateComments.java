/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author stefi
 */
@Entity
@Table(name = "CANDIDATECOMMENTS")
public class CandidateComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    //CAMPURI
    private String comentariu;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CANDIDATE_KEY")
    private Candidate candidate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_KEY")
    private User user;

    
    //ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //CONTINUTUL COMENTARIULUI
    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }

    //CANDIDATUL CARUIA I SE PUNE COMENTARIUL
    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    //USERS CARE AU LASAT COMENTARIU
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CandidateComments)) {
            return false;
        }
        CandidateComments other = (CandidateComments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobs.jobs.entity.CandidateComments[ id=" + id + " ]";
    }
    
}
