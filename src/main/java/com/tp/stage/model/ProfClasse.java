package com.tp.stage.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Entity
@Table(name ="prof_classe")
@EntityListeners(AuditingEntityListener.class)
@IdClass(myKey.class)
public class ProfClasse {

    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "num_prof", nullable = false)
    private Professeur numProf;

    @Id
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "num_classe", nullable = false)
    private Classe numClasse;

    @Column(name="est_prof_principal", nullable = false)
    private int estProfPrincipal;

    public Professeur getNum_prof() {
        return numProf;
    }

    public void setNum_prof(Professeur num_prof) {
        this.numProf = num_prof;
    }

    public Classe getNum_classe() {
        return numClasse;
    }

    public void setNum_classe(Classe num_classe) {
        this.numClasse = num_classe;
    }

    public int getEstProfPrincipal() {
        return estProfPrincipal;
    }

    public void setEstProfPrincipal(int estProfPrincipal) {
        this.estProfPrincipal = estProfPrincipal;
    }
   }
