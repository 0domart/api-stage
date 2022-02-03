package com.tp.stage.model;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name ="classe")
@EntityListeners(AuditingEntityListener.class)
public class Classe {

    @Id
    @Column(name="num_classe", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num_classe;

    @Column(name="nom_classe", nullable = false)
    private String nom_classe;

    @Transient
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "numClasse", orphanRemoval = true, fetch=FetchType.EAGER)
    private List<ProfClasse> listProfClasse = new ArrayList<>();

    public int getNum_classe() {
        return num_classe;
    }

    public void setNum_classe(int num_classe) {
        this.num_classe = num_classe;
    }

    public String getNom_classe() {
        return nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }
}
