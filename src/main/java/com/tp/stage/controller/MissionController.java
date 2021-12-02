package com.tp.stage.controller;


import com.tp.stage.model.Classe;
import com.tp.stage.model.Mission;
import com.tp.stage.repository.ClasseRepository;
import com.tp.stage.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stage/mission")

public class MissionController {

    @Autowired
    private MissionRepository missionRepository;


    @GetMapping("/all")
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mission> getMissionByNumMission(@PathVariable(value="id") Integer num_mission) throws Exception {

        Mission mission = missionRepository.findById(num_mission).orElseThrow(() -> new Exception("Mission not found"));
        return ResponseEntity.ok().body(mission);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Mission> updateMission(
            @PathVariable(value = "id") Integer num_mission, @RequestBody Mission missionDetails)
            throws Exception {

        Mission mission =
                missionRepository
                        .findById(num_mission)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_mission));

        mission.setLibelle(missionDetails.getLibelle());
        mission.setNumStage(missionDetails.getNumStage());
        final Mission updatedMission = missionRepository.save(mission);
        return ResponseEntity.ok(updatedMission);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteMission(@PathVariable(value = "id") Integer num_mission) throws Exception {
        Mission mission =
                missionRepository
                        .findById(num_mission)
                        .orElseThrow(() -> new Exception("User not found on :: " + num_mission));

        missionRepository.delete(mission);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
