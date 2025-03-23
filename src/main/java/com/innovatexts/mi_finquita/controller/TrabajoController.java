package com.innovatexts.mi_finquita.controller;

import com.innovatexts.mi_finquita.dto.TrabajoDTO;
import com.innovatexts.mi_finquita.model.Trabajo;
import com.innovatexts.mi_finquita.model.Usuario;
import com.innovatexts.mi_finquita.repository.UsuarioRepository;
import com.innovatexts.mi_finquita.service.TrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/trabajos")
@CrossOrigin(origins = "*")
public class TrabajoController {

    @Autowired
    private TrabajoService trabajoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // ========== LISTAR TODOS ==========
    @GetMapping
    public List<TrabajoDTO> listarTrabajos() {
        return trabajoService.listarTrabajos().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    // ========== OBTENER POR ID ==========
    @GetMapping("/{id}")
    public ResponseEntity<TrabajoDTO> obtenerTrabajoPorId(@PathVariable Integer id) {
        return trabajoService.obtenerTrabajoPorId(id)
                .map(trabajo -> ResponseEntity.ok(convertEntityToDTO(trabajo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ========== CREAR ==========
    @PostMapping
    public ResponseEntity<TrabajoDTO> crearTrabajo(@RequestBody TrabajoDTO trabajoDTO) {
        // 1. Buscar el usuario por ID
        Usuario usuario = null;
        if (trabajoDTO.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(trabajoDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        }

        // 2. Convertir DTO a Entidad
        Trabajo trabajo = convertDTOToEntity(trabajoDTO, usuario);

        // 3. Guardar en BD
        Trabajo trabajoGuardado = trabajoService.guardarTrabajo(trabajo);

        // 4. Devolver DTO
        return ResponseEntity.ok(convertEntityToDTO(trabajoGuardado));
    }

    // ========== ACTUALIZAR ==========
    @PutMapping("/{id}")
    public ResponseEntity<TrabajoDTO> actualizarTrabajo(@PathVariable Integer id,
                                                        @RequestBody TrabajoDTO trabajoDTO) {
        // Verificar que exista el trabajo
        Trabajo trabajoExistente = trabajoService.obtenerTrabajoPorId(id)
                .orElse(null);
        if (trabajoExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Buscar el usuario
        Usuario usuario = null;
        if (trabajoDTO.getUsuarioId() != null) {
            usuario = usuarioRepository.findById(trabajoDTO.getUsuarioId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        }

        // Actualizar campos del trabajo existente
        trabajoExistente.setDetalles(trabajoDTO.getDetalles());
        trabajoExistente.setFechaInicio(trabajoDTO.getFechaInicio());
        trabajoExistente.setFechaFin(trabajoDTO.getFechaFin());
        trabajoExistente.setTotalInversion(trabajoDTO.getTotalInversion());
        trabajoExistente.setTrabajadoresContratados(trabajoDTO.getTrabajadoresContratados());
        trabajoExistente.setUsuario(usuario);

        // Guardar en BD
        Trabajo trabajoActualizado = trabajoService.guardarTrabajo(trabajoExistente);

        // Devolver DTO
        return ResponseEntity.ok(convertEntityToDTO(trabajoActualizado));
    }

    // ========== ELIMINAR ==========
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTrabajo(@PathVariable Integer id) {
        if (!trabajoService.obtenerTrabajoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        trabajoService.eliminarTrabajo(id);
        return ResponseEntity.noContent().build();
    }

    // ========== MÉTODOS DE CONVERSIÓN ==========

    private TrabajoDTO convertEntityToDTO(Trabajo trabajo) {
        TrabajoDTO dto = new TrabajoDTO();
        dto.setId(trabajo.getId());
        dto.setDetalles(trabajo.getDetalles());
        dto.setFechaInicio(trabajo.getFechaInicio());
        dto.setFechaFin(trabajo.getFechaFin());
        dto.setTotalInversion(trabajo.getTotalInversion());
        dto.setTrabajadoresContratados(trabajo.getTrabajadoresContratados());
        // Si el trabajo tiene usuario, obtenemos el ID
        dto.setUsuarioId(trabajo.getUsuario() != null ? trabajo.getUsuario().getId() : null);
        return dto;
    }

    private Trabajo convertDTOToEntity(TrabajoDTO dto, Usuario usuario) {
        Trabajo trabajo = new Trabajo();
        trabajo.setDetalles(dto.getDetalles());
        trabajo.setFechaInicio(dto.getFechaInicio());
        trabajo.setFechaFin(dto.getFechaFin());
        trabajo.setTotalInversion(dto.getTotalInversion());
        trabajo.setTrabajadoresContratados(dto.getTrabajadoresContratados());
        trabajo.setUsuario(usuario);
        return trabajo;
    }
}
