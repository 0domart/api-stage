package com.tp.stage.repository;

import com.tp.stage.model.ProfClasse;
import com.tp.stage.model.myKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfClasseRepository extends JpaRepository<ProfClasse, myKey> {

}
