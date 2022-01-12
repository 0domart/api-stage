package com.tp.stage.controller;

import com.tp.stage.model.Etudiant;
import com.tp.stage.model.Professeur;
import com.tp.stage.model.loginResponse;
import com.tp.stage.repository.EtudiantRepository;
import com.tp.stage.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/stage/login")

public class loginController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    @GetMapping("/{login}&{password}")
    public loginResponse login(@PathVariable(value = "login") String login, @PathVariable(value = "password") String password) {
        List<Etudiant> ets = etudiantRepository.findAll();
        for(Etudiant item : ets) {
            if(item.getLogin().equals(login) && item.getMdp().equals(password)){
                loginResponse l = new loginResponse();
                l.setLogin(item.getLogin());
                l.setNameUser(item.getNomEtudiant() + ' '+ item.getPrenomEtudiant());
                l.setStatut("etudiant");
                return l;
            };
        }

        List<Professeur> profs = professeurRepository.findAll();
        for(Professeur item : profs) {
            if(item.getLogin().equals(login) && item.getMdp().equals(password)){
                loginResponse l = new loginResponse();
                l.setLogin(item.getLogin());
                l.setNameUser(item.getNomProf());
                l.setStatut("professeur");
                return l;
            };
        }
        loginResponse l = new loginResponse();
        l.setLogin(null);
        l.setNameUser(null);
        l.setStatut("refused");
        return l;
    }
}
