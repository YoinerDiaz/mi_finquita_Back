package com.innovatexts.mi_finquita.repository;

import com.innovatexts.mi_finquita.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
