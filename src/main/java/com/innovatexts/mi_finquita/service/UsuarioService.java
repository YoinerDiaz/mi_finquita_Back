package com.innovatexts.mi_finquita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.innovatexts.mi_finquita.dto.RegistroUsuarioDTO;
import com.innovatexts.mi_finquita.model.Rol;
import com.innovatexts.mi_finquita.model.Usuario;
import com.innovatexts.mi_finquita.repository.RolRepository;
import com.innovatexts.mi_finquita.repository.UsuarioRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Transactional
    public Usuario registrarUsuario(RegistroUsuarioDTO registroDTO) {
        // Verificar si el usuario ya existe
        if (usuarioRepository.existsByUsername(registroDTO.getUsername())) {
            throw new RuntimeException("El nombre de usuario ya está en uso");
        }
        
        // Buscar el rol
        Rol rol = rolRepository.findById(registroDTO.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        
        // Crear el nuevo usuario
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(registroDTO.getUsername());
        nuevoUsuario.setPassword(passwordEncoder.encode(registroDTO.getPassword())); // Encriptamos la contraseña
        nuevoUsuario.setNombre(registroDTO.getNombre());
        nuevoUsuario.setRol(rol);

        // Guardar el usuario
        return usuarioRepository.save(nuevoUsuario);
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
    }
}
