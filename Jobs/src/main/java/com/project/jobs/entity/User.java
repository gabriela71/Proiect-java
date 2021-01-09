/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author stefi
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    //CAMPURI
    private String nume;
    private String prenume;
    private String nrTelefon;
    private String nrMobil;
    private String email;
    private String pozitie;
    private String username;
    private String password;
    
   //@JsonbTransient ????????
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<CandidateComments> cComments;

   @OneToMany(mappedBy = "user")
    private Collection<Position> position;

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<PositionComments> pComments;
   
   
    
    //ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //NUME
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    //PRENUME
    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    //NR. TELEFON
    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }
    
    //NR. MOBIL
    public String getNrMobil() {
        return nrMobil;
    }

    public void setNrMobil(String nrMobil) {
        this.nrMobil = nrMobil;
    }

    //EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //POZITIE
    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    //USERNAME
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //PAROLA
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //COMENTARII ADAUGATE PENTRU CANDIDATI
    public Collection<CandidateComments> getcComments() {
        return cComments;
    }

    public void setcComments(Collection<CandidateComments> cComments) {
        this.cComments = cComments;
    }
    
    //POZITII CREATE DE USER
     public Collection<Position> getPosition() {
        return position;
    }

    public void setPosition(Collection<Position> position) {
        this.position = position;
    }

    //COMENTARII ADAUGATE PENTRU POZITII
    public Collection<PositionComments> getpComments() {
        return pComments;
    }

    public void setpComments(Collection<PositionComments> pComments) {
        this.pComments = pComments;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobs.jobs.entity.User[ id=" + id + " ]";
    }
    
}
