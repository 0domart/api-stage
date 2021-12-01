package com.tp.stage.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name ="specialite")
@EntityListeners(AuditingEntityListener.class)
public class Specialite {

    @Id
    @Column(name="num_spec", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long num_classe;

    @Column(name="libelle", nullable = false)
    private String libelle;

    public long getNum_classe() {
        return num_classe;
    }

    public void setNum_classe(long num_classe) {
        this.num_classe = num_classe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
