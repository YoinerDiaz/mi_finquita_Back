package com.innovatexts.mi_finquita.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innovatexts.mi_finquita.model.TrabajoInsumo;

@Repository
public interface TrabajoInsumoRepository extends JpaRepository<TrabajoInsumo, Integer> {}

