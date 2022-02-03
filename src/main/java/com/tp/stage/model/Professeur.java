package com.tp.stage.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "professeur")
@EntityListeners(AuditingEntityListener.class)
public class Professeur {


    @Id
    private int num_prof;

    @Column(name = "nom_prof", nullable = false)
    private String nomProf;

    @Column(name = "prenom_prof", nullable = false)
    private String prenomProf;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "professeur", fetch=FetchType.EAGER)
    private Collection<Stage> stages = new ArrayList<>();

    @Transient
    @OneToMany(mappedBy = "numProf", orphanRemoval = true, fetch=FetchType.EAGER)
    private List<ProfClasse> listProfClasse = new ArrayList<>();

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

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
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