package com.tp.stage.model;

import java.io.Serializable;

public class myKey implements Serializable {
    private int num_prof;
    private int num_classe;

    public myKey(int a, int b){
        this.num_prof = a;
        this.num_classe = b;
    }
}
