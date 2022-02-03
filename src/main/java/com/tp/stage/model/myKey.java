package com.tp.stage.model;

import java.io.Serializable;

public class myKey implements Serializable {
    private int numProf;
    private int numClasse;

    public myKey(int a, int b){
        this.numProf = a;
        this.numClasse = b;
    }
}
