package com.innovatexts.mi_finquita.repository;

import com.innovatexts.mi_finquita.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer> {
}
