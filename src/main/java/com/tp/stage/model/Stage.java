package com.tp.stage.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name ="stage")
@EntityListeners(AuditingEntityListener.class)
public class Stage {

    @Id
    @Column(name="num_stage", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer numStage;

    @Column(name="debut_stage", nullable = false)
    private Date debutStage;

    @Column(name="fin_stage", nullable = false)
    private Date finStage;

    @Column(name="type_stage", nullable = false)
    private String typeStage;

    @Column(name="desc_projet", nullable = false)
    private String descProjet;

    @Column(name="observation_stage", nullable = false)
    private String observationStage;

    @ManyToOne
    @JoinColumn(name = "num_etudiant")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "num_entreprise")
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "num_prof")
    private Professeur professeur;

    public int getNumStage() {
        return numStage;
    }

    public void setNumStage(int numStage) {
        this.numStage = numStage;
    }

    public Date getDebutStage() {
        return debutStage;
    }

    public void setDebutStage(Date debutStage) {
        this.debutStage = debutStage;
    }

    public Date getFinStage() {
        return finStage;
    }

    public void setFinStage(Date finStage) {
        this.finStage = finStage;
    }

    public String getTypeStage() {
        return typeStage;
    }

    public void setTypeStage(String typeStage) {
        this.typeStage = typeStage;
    }

    public String getDescProjet() {
        return descProjet;
    }

    public void setDescProjet(String descProjet) {
        this.descProjet = descProjet;
    }

    public String getObservationStage() {
        return observationStage;
    }

    public void setObservationStage(String observationStage) {
        this.observationStage = observationStage;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Professeur getProf() {
        return professeur;
    }

    public void setProf(Professeur prof) {
        this.professeur = prof;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
