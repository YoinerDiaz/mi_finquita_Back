package com.innovatexts.mi_finquita.controller;

import com.innovatexts.mi_finquita.dto.CultivoDTO;
import com.innovatexts.mi_finquita.dto.TrabajoDTO;
import com.innovatexts.mi_finquita.model.Cultivo;
import com.innovatexts.mi_finquita.model.Trabajo;
import com.innovatexts.mi_finquita.model.Usuario;
import com.innovatexts.mi_finquita.service.CultivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cultivos")
@CrossOrigin(origins = "*") // Permite acceso desde cualquier dominio
public class CultivoController {

    @Autowired
    private CultivoService cultivoService;

    // Endpoint para guardar un cultivo
    @PostMapping
    public ResponseEntity<CultivoDTO> guardarCultivo(@RequestBody CultivoDTO cultivoDTO) {
        // 1. Convertir DTO a Entidad
        Cultivo cultivo = convertDTOToEntity(cultivoDTO);

        // 2. Guardar en BD
        Cultivo cultivoGuardado = cultivoService.guardarCultivo(cultivo);

        // 3. Devolver DTO
        return ResponseEntity.ok(convertEntityToDTO(cultivoGuardado));
    }

    // Endpoint para obtener todos los cultivos
    @GetMapping
    public List<CultivoDTO> obtenerTodosLosCultivos() {
        return cultivoService.obtenerTodosLosCultivos().stream()
        .map(this::convertEntityToDTO)
        .collect(Collectors.toList());
    }

    // Endpoint para obtener un cultivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<CultivoDTO> obtenerCultivoPorId(@PathVariable Integer id) {
        return cultivoService.obtenerCultivoPorId(id)
        .map(cultivo -> ResponseEntity.ok(convertEntityToDTO(cultivo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para actualizar un cultivo
    @PutMapping("/{id}")
    public ResponseEntity<CultivoDTO> actualizarCultivo(@PathVariable Integer id,
                                                        @RequestBody CultivoDTO cultivoDTO) {
        // Verificar que exista el cultivo
        Cultivo cultivoExistente = cultivoService.obtenerCultivoPorId(id)
                .orElse(null);
        if (cultivoExistente == null) {
            return ResponseEntity.notFound().build();
        }


        // Actualizar campos del cultivo existente
        cultivoExistente.setNombre(cultivoDTO.getNombre());
        cultivoExistente.setDescripcion(cultivoDTO.getDescripcion());
        cultivoExistente.setTipo(cultivoDTO.getTipo());
        cultivoExistente.setVariedad(cultivoDTO.getVariedad());
        cultivoExistente.setFechaSiembra(cultivoDTO.getFecha_siembra());
        cultivoExistente.setFechaCosecha(cultivoDTO.getFecha_cosecha());
        cultivoExistente.setAreaHectareas(cultivoDTO.getArea_hectareas());
        cultivoExistente.setUbicacion(cultivoDTO.getUbicacion());
        cultivoExistente.setEstado(cultivoDTO.getEstado());

        // Guardar en BD
        Cultivo cultivoActualizado = cultivoService.guardarCultivo(cultivoExistente);

        // Devolver DTO
        return ResponseEntity.ok(convertEntityToDTO(cultivoActualizado));
    }

    // Endpoint para eliminar un cultivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCultivo(@PathVariable Integer id) {
        boolean eliminado = cultivoService.eliminarCultivo(id);
        if (eliminado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ========== MÉTODOS DE CONVERSIÓN ==========

    private CultivoDTO convertEntityToDTO(Cultivo cultivo) {
        CultivoDTO dto = new CultivoDTO();
        dto.setId(cultivo.getId());
        dto.setNombre(cultivo.getNombre());
        dto.setDescripcion(cultivo.getDescripcion());
        dto.setTipo(cultivo.getTipo());
        dto.setVariedad(cultivo.getVariedad());
        dto.setFecha_siembra(cultivo.getFechaSiembra());
        dto.setFecha_cosecha(cultivo.getFechaCosecha());
        dto.setArea_hectareas(cultivo.getAreaHectareas());
        dto.setUbicacion(cultivo.getUbicacion());
        dto.setEstado(cultivo.getEstado());
        return dto;
    }

    private Cultivo convertDTOToEntity(CultivoDTO dto) {
        Cultivo cultivo = new Cultivo();
        cultivo.setId(dto.getId());
        cultivo.setNombre(dto.getNombre());
        cultivo.setDescripcion(dto.getDescripcion());
        cultivo.setTipo(dto.getTipo());
        cultivo.setVariedad(dto.getVariedad());
        cultivo.setFechaSiembra(dto.getFecha_siembra());
        cultivo.setFechaCosecha(dto.getFecha_cosecha());
        cultivo.setAreaHectareas(dto.getArea_hectareas());
        cultivo.setUbicacion(dto.getUbicacion());
        cultivo.setEstado(dto.getEstado());
        return cultivo;
    }
}
