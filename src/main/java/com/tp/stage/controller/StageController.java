package com.tp.stage.controller;


import com.tp.stage.model.Stage;
import com.tp.stage.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage/stage")

public class StageController {

    @Autowired
    private StageRepository stageRepository;


    @GetMapping("/all")
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stage> GetStageByNumStage(@PathVariable(value="id") Long num_stage) throws Exception {

        Stage stage = stageRepository.findById(num_stage).orElseThrow(() -> new Exception("Stage not found"));
        return ResponseEntity.ok().body(stage);
    }

    @PostMapping("/")
    public Stage createStage(@RequestBody Stage stage) {
        return stageRepository.save(stage);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Stage> updateStage(
            @PathVariable(value = "id") Long num_stage, @RequestBody Stage newStage)
            throws Exception {

        Stage stage =
                stageRepository
                        .findById(num_stage)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_stage));

        stage.setDebutStage(newStage.getDebutStage());
        stage.setFinStage(newStage.getFinStage());
        stage.setTypeStage(newStage.getTypeStage());
        stage.setDescProjet(newStage.getDescProjet());
        stage.setObservationStage(newStage.getObservationStage());
        stage.setNumEtudiant(newStage.getNumEtudiant());
        stage.setNumProf(newStage.getNumProf());
        stage.setNumEntreprise(newStage.getNumEntreprise());

        final Stage updatedStage = stageRepository.save(stage);
        return ResponseEntity.ok(updatedStage);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long num_stage) throws Exception {
        Stage stage =
                stageRepository
                        .findById(num_stage)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_stage));

        stageRepository.delete(stage);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
