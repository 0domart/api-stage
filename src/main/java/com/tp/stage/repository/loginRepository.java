package com.tp.stage.repository;

import com.tp.stage.model.loginResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginRepository extends JpaRepository<loginResponse, Integer> {}
