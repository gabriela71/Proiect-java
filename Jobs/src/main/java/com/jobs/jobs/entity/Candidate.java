/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobs.jobs.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author stefi
 */
@Entity
@Table(name = "CANDIDATE")
public class Candidate implements Serializable {

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
    private String address;
    private Date dataInterviu;
    
    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CV cv;
    
    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<CandidateComments> comments;
    
    
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

    //ADRESA
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //DATA LA CARE A AVUT LOC INTERVIUL
    public Date getDataInterviu() {
        return dataInterviu;
    }

    public void setDataInterviu(Date dataInterviu) {
        this.dataInterviu = dataInterviu;
    }

    //CV
    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    //COMENTARIILE LASATE DE USERS
    public Collection<CandidateComments> getComments() {
        return comments;
    }

    public void setComments(Collection<CandidateComments> comments) {
        this.comments = comments;
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
        if (!(object instanceof Candidate)) {
            return false;
        }
        Candidate other = (Candidate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobs.jobs.entity.Candidate[ id=" + id + " ]";
    }
    
}
