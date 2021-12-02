package com.tp.stage.controller;

import com.tp.stage.model.Professeur;
import com.tp.stage.model.Specialite;
import com.tp.stage.repository.ProfesseurRepository;
import com.tp.stage.repository.SpecialiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage/specialite")
public class SpecialiteController {

    @Autowired
    private SpecialiteRepository specialiteRepository;


    @GetMapping("/all")
    public List<Specialite> getAllProfesseur() {
        return specialiteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialite> getProfesseurById(@PathVariable(value = "id") Integer professeurId)
            throws Exception {
        Specialite specialite =
                specialiteRepository
                        .findById(professeurId)
                        .orElseThrow(() -> new Exception("Exception"));
        return ResponseEntity.ok().body(specialite);
    }

    @PostMapping("/")
    public Specialite createProfesseur(@RequestBody Specialite specialite) {
        return specialiteRepository.save(specialite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specialite> updateProfesseur(
            @PathVariable(value = "id") Integer userId, @RequestBody Specialite specialiteDetails)
            throws Exception {

        Specialite specialite =
                specialiteRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("Exception"));

        specialite.setLibelle(specialiteDetails.getLibelle());

        final Specialite updatedSpecialite = specialiteRepository.save(specialite);
        return ResponseEntity.ok(updatedSpecialite);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteProfesseur(@PathVariable(value = "id") int specialiteId) throws Exception {
        Specialite specialite =
                specialiteRepository
                        .findById(specialiteId)
                        .orElseThrow(() -> new Exception("Exception"));

        specialiteRepository.delete(specialite);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
