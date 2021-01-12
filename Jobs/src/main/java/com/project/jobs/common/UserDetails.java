/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.jobs.common;

import com.project.jobs.entity.CandidateComments;
import com.project.jobs.entity.Position;
import com.project.jobs.entity.PositionComments;
import java.util.Collection;

/**
 *
 * @author Andrei
 */
public class UserDetails {

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
    private Collection<CandidateComments> cComments;
    private Collection<Position> position;
    private Collection<PositionComments> pComments;

    public UserDetails(Integer id, String nume, String prenume, String nrTelefon, String nrMobil, String email, String pozitie, String username) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.nrTelefon = nrTelefon;
        this.nrMobil = nrMobil;
        this.email = email;
        this.pozitie = pozitie;
        this.username = username;
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

    public String getPozitie() {
        return pozitie;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<CandidateComments> getcComments() {
        return cComments;
    }

    public Collection<Position> getPosition() {
        return position;
    }

    public Collection<PositionComments> getpComments() {
        return pComments;
    }

}
