package com.tp.stage.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "professeur")
@EntityListeners(AuditingEntityListener.class)
public class Professeur {


    @Id
    private int num_prof;

    @Column(name = "nom_prof", nullable = false)
    private String nomProf;

    @Column(name = "prenom_prof", nullable = false)
    private String prenomEtudiant;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "email", nullable = false)
    private String email;

    public int getNum_prof() {
        return num_prof;
    }

    public void setNum_prof(int num_prof) {
        this.num_prof = num_prof;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}