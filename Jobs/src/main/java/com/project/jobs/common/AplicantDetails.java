/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.common;

import java.util.Date;
import java.util.List;

/**
 *
 * @author stefi
 */
public class AplicantDetails {
    
    //din candidat
    private String nume;
    private String prenume;
    private String nrTelefon;
    private String nrMobil;
    private String email;
    
    //din aplicant
    private int confirmat;
    private Date dataInterviu;
    private int propus;
    private int ales;
    private Integer id;
    
    //din pozitie
    private String denumire;
    private String departament;

    public AplicantDetails(Integer id, String nume, String prenume, String nrTelefon, String nrMobil, String email, int confirmat, Date dataInterviu, int propus, int ales, String denumire, String departament) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.nrMobil = nrMobil;
        this.email = email;
        this.confirmat = confirmat;
        this.dataInterviu = dataInterviu;
        this.propus = propus;
        this.ales = ales;
        this.denumire = denumire;
        this.departament = departament;
    }

    
    

    public Integer getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public String getNrMobil() {
        return nrMobil;
    }

    public String getEmail() {
        return email;
    }    

    public int getConfirmat() {
        return confirmat;
    }

    public Date getDataInterviu() {
        return dataInterviu;
    }

    public int getPropus() {
        return propus;
    }

    public int getAles() {
        return ales;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getDepartament() {
        return departament;
    }
    
    
}
