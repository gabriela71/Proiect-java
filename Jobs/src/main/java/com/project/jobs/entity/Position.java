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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author stefi
 */
@Entity
@Table(name = "POSITION" )
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    //CAMPURI
    private String denumire;
    private String departament;
    private String cerinte;
    private String responsabilitati;
    private String beneficii;
    private int nrPersoaneCautate;
    private int nrPersoaneAprobate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_KEY")
    private User user;
    
    @OneToOne(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PositionDetails pozD;
    
    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<PositionComments> comments;
    
    
    //ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //DENUMIRE
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    //DEPARTAMENT
    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    //CERINTE
    public String getCerinte() {
        return cerinte;
    }

    public void setCerinte(String cerinte) {
        this.cerinte = cerinte;
    }

    //RESPONSABILITATI
    public String getResponsabilitati() {
        return responsabilitati;
    }

    public void setResponsabilitati(String responsabilitati) {
        this.responsabilitati = responsabilitati;
    }

    //BENEFICII
    public String getBeneficii() {
        return beneficii;
    }

    public void setBeneficii(String beneficii) {
        this.beneficii = beneficii;
    }

    //NR PERSOANE CAUTATE PT POZITIE
    public int getNrPersoaneCautate() {
        return nrPersoaneCautate;
    }

    public void setNrPersoaneCautate(int nrPersoaneCautate) {
        this.nrPersoaneCautate = nrPersoaneCautate;
    }

    //NR PERSOANE GASITE PENTRU POZITIE (CAND NR PERSOANE GASITE = NR PESOANE CAUTATE POZITIA SE INCHIDE)
    public int getNrPersoaneAprobate() {
        return nrPersoaneAprobate;
    }

    public void setNrPersoaneAprobate(int nrPersoaneAprobate) {
        this.nrPersoaneAprobate = nrPersoaneAprobate;
    }

    //CINE A DESCHIS POZITIA
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    //DETALII LEGATE DE APROBARE
    public PositionDetails getPozD() {
        return pozD;
    }

    public void setPozD(PositionDetails pozD) {
        this.pozD = pozD;
    }

    //COMENTARII
    public Collection<PositionComments> getComments() {
        return comments;
    }

    public void setComments(Collection<PositionComments> comments) {
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
        if (!(object instanceof Position)) {
            return false;
        }
        Position other = (Position) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jobs.jobs.entity.Position[ id=" + id + " ]";
    }
    
}
