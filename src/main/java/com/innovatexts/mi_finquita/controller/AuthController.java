package com.innovatexts.mi_finquita.controller;
import com.innovatexts.mi_finquita.dto.JwtResponseDTO;
import com.innovatexts.mi_finquita.dto.LoginDTO;
import com.innovatexts.mi_finquita.dto.RegistroUsuarioDTO;
import com.innovatexts.mi_finquita.model.Usuario;
import com.innovatexts.mi_finquita.security.JwtTokenProvider;
import com.innovatexts.mi_finquita.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        
        // Obtener detalles del usuario
        Usuario usuario = usuarioService.findByUsername(loginDTO.getUsername());
        
        return ResponseEntity.ok(new JwtResponseDTO(
                jwt,
                usuario.getId(),
                usuario.getUsername(),
                usuario.getNombre(),
                usuario.getRol().getNombre()
        ));
    }
    
    @PostMapping("/registro")
    public ResponseEntity<?> register(@Valid @RequestBody RegistroUsuarioDTO registroDTO) {
        Usuario usuario = usuarioService.registrarUsuario(registroDTO);
        
        // Autenticar al usuario recién registrado
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(registroDTO.getUsername(), registroDTO.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtTokenProvider.generateToken(authentication);
        
        return ResponseEntity.ok(new JwtResponseDTO(
                jwt,
                usuario.getId(),
                usuario.getUsername(),
                usuario.getNombre(),
                usuario.getRol().getNombre()
        ));
    }
}
