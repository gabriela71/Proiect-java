/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author stefi
 */
@Entity
@Table(name = "APLICANTI")
public class Aplicanti implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //CAMPURI
    private int idCandidat;
    private int idPozitie;
    private int confirmat;
    private Date dataInterviu;
    private int propus;
    private int ales;

    //ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //ID-UL CANDIDATULUI CARE APLICA PENTRU O POZITIE
    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    //ID-UL POZITIEI LA CARE S-A APLICAT
    public int getIdPozitie() {
        return idPozitie;
    }

    public void setIdPozitie(int idPozitie) {
        this.idPozitie = idPozitie;
    }
    
    //STAREA CANDIDATULUI (1= ACCEPTAT, 0=NEACCEPTAT)
    public int getConfirmat() {
        return confirmat;
    }

    public void setConfirmat(int confirmat) {
        this.confirmat = confirmat;
    }

    //DATA INTERVIULUI
    public Date getDataInterviu() {
        return dataInterviu;
    }

    public void setDataInterviu(Date dataInterviu) {
        this.dataInterviu = dataInterviu;
    }

    // PROPUS/NEPROPUS
    public int getPropus() {
        return propus;
    }

    public void setPropus(int propus) {
        this.propus = propus;
    }

    //ALES/NEALES
    public int getAles() {
        return ales;
    }

    public void setAles(int ales) {
        this.ales = ales;
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
        if (!(object instanceof Aplicanti)) {
            return false;
        }
        Aplicanti other = (Aplicanti) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.jobs.entity.Aplicanti[ id=" + id + " ]";
    }
    
}
