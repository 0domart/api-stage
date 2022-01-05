package com.tp.stage.controller;


import com.tp.stage.model.Classe;
import com.tp.stage.model.ProfClasse;
import com.tp.stage.model.myKey;
import com.tp.stage.repository.ClasseRepository;
import com.tp.stage.repository.ProfClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/stage/profclasse")

public class ProfClasseController {

    @Autowired
    private ProfClasseRepository profClasseRepository;


    @GetMapping("/all")
    public List<ProfClasse> getAllClasses() {
        return profClasseRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfClasse> getClasseByNumClasse(ProfClasseRepository profClasseRepository) throws Exception {
        myKey myKey = new myKey(1, 1);
        ProfClasse profClasse = profClasseRepository.findById(myKey).orElseThrow(() -> new Exception("Classe not found"));
        return ResponseEntity.ok().body(profClasse);
    }

    /*
    @PutMapping("/{id}")
    public ResponseEntity<ProfClasse> updateClasse(
            @PathVariable(value = "id") Integer num_classe, @RequestBody ProfClasse Details)
            throws Exception {

        ProfClasse profClasse =
                profClasseRepository
                        .findById(num_classe)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_classe));

        profClasse.setEstProfPrincipal(Details.getEstProfPrincipal());
        final ProfClasse updatedProfClasse = profClasseRepository.save(profClasse);
        return ResponseEntity.ok(updatedProfClasse);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer num_classe) throws Exception {
        ProfClasse profClasse =
                profClasseRepository
                        .findById(num_classe)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_classe));

        profClasseRepository.delete(profClasse);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    */

}
