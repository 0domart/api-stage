package com.tp.stage.repository;

import com.tp.stage.model.Classe;
import com.tp.stage.model.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {

}
