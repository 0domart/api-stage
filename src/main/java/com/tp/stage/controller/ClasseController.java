package com.tp.stage.controller;


import com.tp.stage.repository.ClasseRepository;
import com.tp.stage.model.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage/classe")

public class ClasseController {

    @Autowired
    private ClasseRepository classeRepository;


    @GetMapping("/all")
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classe> getClasseByNumClasse(@PathVariable(value="id") Integer num_classe) throws Exception {

        Classe classe = classeRepository.findById(num_classe).orElseThrow(() -> new Exception("Classe not found"));
        return ResponseEntity.ok().body(classe);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Classe> updateClasse(
            @PathVariable(value = "id") Integer num_classe, @RequestBody Classe classeDetails)
            throws Exception {

        Classe classe =
                classeRepository
                        .findById(num_classe)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_classe));

        classe.setNom_classe(classeDetails.getNom_classe());
        final Classe updatedUser = classeRepository.save(classe);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer num_classe) throws Exception {
        Classe classe =
                classeRepository
                        .findById(num_classe)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_classe));

        classeRepository.delete(classe);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
