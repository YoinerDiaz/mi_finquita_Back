package com.innovatexts.mi_finquita.repository;

import com.innovatexts.mi_finquita.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByUsername(String username);
    Optional<Usuario> findByUsername(String username);
}