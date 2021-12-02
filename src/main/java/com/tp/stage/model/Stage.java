package com.tp.stage.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;


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

    @Column(name="num_etudiant", nullable = false)
    private int numEtudiant;

    @Column(name="num_prof", nullable = false)
    private int numProf;

    @Column(name="num_entreprise", nullable = false)
    private int numEntreprise;

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

    public int getNumEtudiant() {
        return numEtudiant;
    }

    public void setNumEtudiant(int numEtudiant) {
        this.numEtudiant = numEtudiant;
    }

    public int getNumProf() {
        return numProf;
    }

    public void setNumProf(int numProf) {
        this.numProf = numProf;
    }

    public int getNumEntreprise() {
        return numEntreprise;
    }

    public void setNumEntreprise(int numEntreprise) {
        this.numEntreprise = numEntreprise;
    }
}
