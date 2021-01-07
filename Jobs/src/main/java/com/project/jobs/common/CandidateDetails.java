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
public class CandidateDetails {
    
    private Integer id;
    private String nume;
    private String prenume;
    private String nrTelefon;
    private String nrMobil;
    private String email;
    private String address;

    public CandidateDetails(Integer id, String nume, String prenume, String nrTelefon, String nrMobil, String email, String address) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.nrMobil = nrMobil;
        this.email = email;
        this.address = address;
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

    public String getAddress() {
        return address;
    }
    
    
    
    
}
