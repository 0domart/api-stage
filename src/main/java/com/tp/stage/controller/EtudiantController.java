package com.tp.stage.controller;

import com.tp.stage.model.Etudiant;
import com.tp.stage.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/stage/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping("/all")
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable(value = "id") Integer userId)
            throws Exception {
        Etudiant etudiant =
                etudiantRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("Exception"));
        return ResponseEntity.ok().body(etudiant);
    }

    @PostMapping("/")
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(
            @PathVariable(value = "id") Integer userId, @RequestBody Etudiant etudiantDetails)
            throws Exception {

        Etudiant etudiant =
                etudiantRepository
                        .findById(userId)
                        .orElseThrow(() -> new Exception("Exception"));

        etudiant.setNomEtudiant(etudiantDetails.getNomEtudiant());
        etudiant.setPrenomEtudiant(etudiantDetails.getPrenomEtudiant());
        etudiant.setAnneeObtention(etudiantDetails.getAnneeObtention());
        etudiant.setLogin(etudiantDetails.getLogin());
        etudiant.setMdp(etudiantDetails.getMdp());
        etudiant.setNumClasse(etudiantDetails.getNumClasse());
        final Etudiant updatedEtudiant = etudiantRepository.save(etudiant);
        return ResponseEntity.ok(updatedEtudiant);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUtilisateur(@PathVariable(value = "id") int etudiantId) throws Exception {
        Etudiant etudiant =
                etudiantRepository
                        .findById(etudiantId)
                        .orElseThrow(() -> new Exception("Exception"));

        etudiantRepository.delete(etudiant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
