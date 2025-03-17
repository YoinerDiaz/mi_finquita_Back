package com.innovatexts.mi_finquita.repository;

import com.innovatexts.mi_finquita.model.Cultivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CultivoRepository extends JpaRepository<Cultivo, Integer> {
}
