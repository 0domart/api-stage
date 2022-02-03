package com.tp.stage.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

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

    public Stage getNumStage() {
        return stage;
    }

    public void setNumStage(Stage numStage) {
        this.stage = numStage;
    }

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.EAGER)
    @JoinColumn(name = "num_stage")
    private Stage stage;


}
