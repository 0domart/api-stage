package com.tp.stage.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;


@Entity
@Table(name ="profclasse")
@EntityListeners(AuditingEntityListener.class)
@IdClass(myKey.class)
public class ProfClasse {

    @Id
    @Column(name="num_prof", nullable = false)
    private int num_prof;

    @Id
    @Column(name="nom_classe", nullable = false)
    private int num_classe;

    @Column(name="est_prof_principal", nullable = false)
    private int estProfPrincipal;

    public int getNum_prof() {
        return num_prof;
    }

    public void setNum_prof(int num_prof) {
        this.num_prof = num_prof;
    }

    public int getNum_classe() {
        return num_classe;
    }

    public void setNum_classe(int num_classe) {
        this.num_classe = num_classe;
    }

    public int getEstProfPrincipal() {
        return estProfPrincipal;
    }

    public void setEstProfPrincipal(int estProfPrincipal) {
        this.estProfPrincipal = estProfPrincipal;
    }
   }
