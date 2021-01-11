/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.common;

import java.util.Date;

/**
 *
 * @author Alex
 */
public class CandidateDetails {
    
    private Integer id;
    private String username;
    private String nume;
    private String prenume;
    private String nrTelefon;
    private String nrMobil;
    private String email;
    private String address;

    public CandidateDetails(Integer id, String username, String nume, String prenume, String nrTelefon, String nrMobil, String email, String address) {
        this.id = id;
        this.username = username;
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

    public String getUsername() {
        return username;
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
