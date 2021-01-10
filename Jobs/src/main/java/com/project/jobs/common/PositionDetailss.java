/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.common;

/**
 *
 * @author Alex
 */
public class PositionDetailss {
    private Integer id;
    private String denumire;
    private String departament;
    private String cerinte;
    private String responsabilitati;
    private String beneficii;
    private int nrPersoaneCautate;
    private int nrPersoaneAprobate;

    public PositionDetailss(Integer id, String denumire, String departament, String cerinte, String responsabilitati, String beneficii, int nrPersoaneCautate, int nrPersoaneAprobate) {
        this.id = id;
        this.denumire = denumire;
        this.departament = departament;
        this.cerinte = cerinte;
        this.responsabilitati = responsabilitati;
        this.beneficii = beneficii;
        this.nrPersoaneCautate = nrPersoaneCautate;
        this.nrPersoaneAprobate = nrPersoaneAprobate;
    }

    public Integer getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getDepartament() {
        return departament;
    }

    public String getCerinte() {
        return cerinte;
    }

    public String getResponsabilitati() {
        return responsabilitati;
    }

    public String getBeneficii() {
        return beneficii;
    }

    public int getNrPersoaneCautate() {
        return nrPersoaneCautate;
    }

    public int getNrPersoaneAprobate() {
        return nrPersoaneAprobate;
    }
    
    
}
