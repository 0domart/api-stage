package com.tp.stage.controller;

import com.tp.stage.model.Entreprise;
import com.tp.stage.model.Etudiant;
import com.tp.stage.repository.EntrepriseRepository;
import com.tp.stage.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage/entreprise")
public class EntrepriseController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/all")
    public List<Entreprise> getAllEntreprises() {
        return entrepriseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable(value = "id") Integer num_entreprise)
            throws Exception {
        Entreprise entreprise =
                entrepriseRepository
                        .findById(num_entreprise)
                        .orElseThrow(() -> new Exception("Exception"));
        return ResponseEntity.ok().body(entreprise);
    }

    @PostMapping("/")
    public Entreprise createEntreprise(@RequestBody Entreprise entreprise) {
        return entrepriseRepository.save(entreprise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entreprise> updateEntreprise(
            @PathVariable(value = "id") Integer num_entreprise, @RequestBody Entreprise entrepriseDetails)
            throws Exception {

        Entreprise entreprise =
                entrepriseRepository
                        .findById(num_entreprise)
                        .orElseThrow(() -> new Exception("Exception"));

        entreprise.setCpEntreprise(entrepriseDetails.getCpEntreprise());
        entreprise.setFaxEntreprise(entrepriseDetails.getFaxEntreprise());
        entreprise.setRueEntreprise(entrepriseDetails.getRueEntreprise());
        entreprise.setSiteEntreprise(entrepriseDetails.getSiteEntreprise());
        entreprise.setTelEntreprise(entrepriseDetails.getTelEntreprise());
        entreprise.setVilleEntreprise(entrepriseDetails.getVilleEntreprise());
        entreprise.setNiveau(entrepriseDetails.getNiveau());
        entreprise.setObservation(entrepriseDetails.getObservation());
        entreprise.setEmail(entrepriseDetails.getEmail());
        entreprise.setEnActivite(entrepriseDetails.getEnActivite());
        entreprise.setNomContact(entrepriseDetails.getNomContact());
        entreprise.setNomResp(entrepriseDetails.getNomResp());

        final Entreprise updatedEntreprise = entrepriseRepository.save(entreprise);
        return ResponseEntity.ok(updatedEntreprise);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteEntreprise(@PathVariable(value = "id") int entrepriseId) throws Exception {
        Entreprise entreprise =
                entrepriseRepository
                        .findById(entrepriseId)
                        .orElseThrow(() -> new Exception("Exception"));

        entrepriseRepository.delete(entreprise);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
