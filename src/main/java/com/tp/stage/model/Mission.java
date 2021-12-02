package com.tp.stage.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Table(name ="mission")
@EntityListeners(AuditingEntityListener.class)
public class Mission {

    @Id
    @Column(name="num_mission", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numMission;

    @Column(name="libelle", nullable = false)
    private String libelle;

    public int getNumMission() {
        return numMission;
    }

    public void setNumMission(int numMission) {
        this.numMission = numMission;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNumStage() {
        return numStage;
    }

    public void setNumStage(int numStage) {
        this.numStage = numStage;
    }

    @Column(name="num_stage", nullable = false)
    private int numStage;



}
