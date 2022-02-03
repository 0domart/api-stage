package com.tp.stage.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "etudiant")
@EntityListeners(AuditingEntityListener.class)
public class Etudiant {

    @Id
    private int num_etudiant;

    @Column(name = "nom_etudiant", nullable = false)
    private String nomEtudiant;

    @Column(name = "prenom_etudiant", nullable = false)
    private String prenomEtudiant;

    @Column(name = "annee_obtention")
    private Date anneeObtention;

    @Column(name = "login", nullable = false)
    private String login;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "num_classe", nullable = false)
    private int numClasse;

    @Column(name = "en_activite", nullable = false)
    private int enActivite;

    @OneToMany(mappedBy = "etudiant", cascade = {CascadeType.REMOVE}, orphanRemoval = true,fetch=FetchType.EAGER)

    private Collection<Stage> stages = new ArrayList<>();

    public int getNum_etudiant() {
        return num_etudiant;
    }

    public void setNum_etudiant(int num_etudiant) {
        this.num_etudiant = num_etudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Date getAnneeObtention() {
        return anneeObtention;
    }

    public void setAnneeObtention(Date anneeObtention) {
        this.anneeObtention = anneeObtention;
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

    public int getNumClasse() {
        return numClasse;
    }

    public void setNumClasse(int numClasse) {
        this.numClasse = numClasse;
    }

    public int getEnActivite() {
        return enActivite;
    }

    public void setEnActivite(int enActivite) {
        this.enActivite = enActivite;
    }

}