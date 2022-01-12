package com.tp.stage.model;

import javax.persistence.*;

@Entity
public class loginResponse {

    @Id
    private String login;
    private String statut;
    private String nameUser;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

}
