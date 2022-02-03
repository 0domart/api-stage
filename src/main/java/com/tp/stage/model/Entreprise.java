package com.tp.stage.model;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "entreprise")
@EntityListeners(AuditingEntityListener.class)
public class Entreprise {

    @Id
    private int num_entreprise;

    @Column(name = "nom_contact")
    private String nomContact;

    @Column(name = "nom_resp")
    private String nomResp;

    @Column(name = "raison_sociale", nullable = false)
    private String raisonSociale;

    @Column(name = "rue_entreprise")
    private String rueEntreprise;

    @Column(name = "cp_entreprise")
    private int cpEntreprise;

    @Column(name = "ville_entreprise", nullable = false)
    private String villeEntreprise;

    @Column(name = "tel_entreprise")
    private String telEntreprise;

    @Column(name = "fax_entreprise")
    private String faxEntreprise;

    @Column(name = "email")
    private String email;

    @Column(name = "niveau", nullable = false)
    private String niveau;

    @Column(name = "observation")
    private String observation;

    @Column(name = "site_entreprise", nullable = false)
    private String siteEntreprise;

    @JoinTable(name = "spec_entreprise", joinColumns = {@JoinColumn(name="num_entreprise")},
    inverseJoinColumns = {@JoinColumn(name = "num_spec")})
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE }, fetch = FetchType.LAZY)
    private List<Specialite> specialite;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "entreprise", orphanRemoval = true, fetch=FetchType.EAGER)
    private Collection<Stage> stages = new ArrayList<>();

    public List<Specialite> getSpecialite() {
        return specialite;
    }

    public void setSpecialite(List<Specialite> specialite) {
        this.specialite = specialite;
    }

    public int getNum_entreprise() {
        return num_entreprise;
    }

    public void setNum_entreprise(int num_entreprise) {
        this.num_entreprise = num_entreprise;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public String getNomResp() {
        return nomResp;
    }

    public void setNomResp(String nomResp) {
        this.nomResp = nomResp;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getRueEntreprise() {
        return rueEntreprise;
    }

    public void setRueEntreprise(String rueEntreprise) {
        this.rueEntreprise = rueEntreprise;
    }

    public int getCpEntreprise() {
        return cpEntreprise;
    }

    public void setCpEntreprise(int cpEntreprise) {
        this.cpEntreprise = cpEntreprise;
    }

    public String getVilleEntreprise() {
        return villeEntreprise;
    }

    public void setVilleEntreprise(String villeEntreprise) {
        this.villeEntreprise = villeEntreprise;
    }

    public String getTelEntreprise() {
        return telEntreprise;
    }

    public void setTelEntreprise(String telEntreprise) {
        this.telEntreprise = telEntreprise;
    }

    public String getFaxEntreprise() {
        return faxEntreprise;
    }

    public void setFaxEntreprise(String faxEntreprise) {
        this.faxEntreprise = faxEntreprise;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getSiteEntreprise() {
        return siteEntreprise;
    }

    public void setSiteEntreprise(String siteEntreprise) {
        this.siteEntreprise = siteEntreprise;
    }

    public int getEnActivite() {
        return enActivite;
    }

    public void setEnActivite(int enActivite) {
        this.enActivite = enActivite;
    }

    @Column(name = "en_activite", nullable = false)
    private int enActivite;

}