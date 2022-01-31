package com.tp.stage.controller;

import com.tp.stage.model.Etudiant;
import com.tp.stage.model.Professeur;
import com.tp.stage.repository.EtudiantRepository;
import com.tp.stage.repository.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/stage/professeur")
public class ProfesseurController {

    @Autowired
    private ProfesseurRepository professeurRepository;


    @GetMapping("/all")
    public List<Professeur> getAllProfesseur() {
        return professeurRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professeur> getProfesseurById(@PathVariable(value = "id") Integer professeurId)
            throws Exception {
        Professeur professeur =
                professeurRepository
                        .findById(professeurId)
                        .orElseThrow(() -> new Exception("Exception"));
        return ResponseEntity.ok().body(professeur);
    }

    @PostMapping("/")
    public Professeur createProfesseur(@RequestBody Professeur professeur) {
        return professeurRepository.save(professeur);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professeur> updateProfesseur(
            @PathVariable(value = "id") Integer userId, @RequestBody Professeur professeurDetails)
            throws Exception {

        Professeur professeur =
                professeurRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("Exception"));

        professeur.setPrenomProf(professeurDetails.getPrenomProf());
        professeur.setLogin(professeurDetails.getLogin());
        professeur.setNomProf(professeurDetails.getNomProf());
        professeur.setEmail(professeurDetails.getEmail());
        professeur.setMdp(professeurDetails.getMdp());

        final Professeur updatedProfesseur = professeurRepository.save(professeur);
        return ResponseEntity.ok(updatedProfesseur);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProfesseur(@PathVariable(value = "id") int professeurId) throws Exception {
        Professeur professeur =
                professeurRepository
                        .findById(professeurId)
                        .orElseThrow(() -> new Exception("Exception"));

        professeurRepository.delete(professeur);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
