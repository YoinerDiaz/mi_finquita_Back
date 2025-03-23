package com.innovatexts.mi_finquita.repository;

import com.innovatexts.mi_finquita.model.Trabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajo, Integer> {
}

