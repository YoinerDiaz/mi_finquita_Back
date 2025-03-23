package com.innovatexts.mi_finquita.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.innovatexts.mi_finquita.dto.InsumoDTO;
import com.innovatexts.mi_finquita.model.Insumo;
import com.innovatexts.mi_finquita.service.InsumoService;



@RestController
@RequestMapping("/api/insumo")
@CrossOrigin(origins = "*")
public class InsumoController {
    @Autowired
    private InsumoService insumoService;

    // ========== LISTAR TODOS ==========
    @GetMapping
    public List<InsumoDTO> listarInsumo() {
        return insumoService.listarInsumos().stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    // ========== OBTENER POR ID ==========
    @GetMapping("/{id}")
    public ResponseEntity<InsumoDTO> obtenerInsumoPorId(@PathVariable Integer id) {
        return insumoService.obtenerInsumoPorId(id)
                .map(insumo -> ResponseEntity.ok(convertEntityToDTO(insumo)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ========== CREAR ==========
    @PostMapping
    public ResponseEntity<InsumoDTO> crearInsumo(@RequestBody InsumoDTO insumoDTO) {

        // 1. Convertir DTO a Entidad
        Insumo insumo = convertDTOToEntity(insumoDTO);

        // 2. Guardar en BD
        Insumo insumoGuardado = insumoService.guardarInsumo(insumo);

        // 3. Devolver DTO
        return ResponseEntity.ok(convertEntityToDTO(insumoGuardado));
    }

    // ========== ACTUALIZAR ==========
    @PutMapping("/{id}")
    public ResponseEntity<InsumoDTO> actualizarInsumo(@PathVariable Integer id,
                                                        @RequestBody InsumoDTO insumoDTO) {
        // Verificar que exista el trabajo
        Insumo insumoExistente = insumoService.obtenerInsumoPorId(id)
                .orElse(null);
        if (insumoExistente == null) {
            return ResponseEntity.notFound().build();
        }


        // Actualizar campos del trabajo existente
        insumoExistente.setNombre(insumoDTO.getNombre());
        insumoExistente.setDescripcion(insumoDTO.getDescripcion());
        insumoExistente.setStock(insumoDTO.getStock());
        insumoExistente.setCosto_unitario(insumoDTO.getCosto_unitario());
        insumoExistente.setFecha_compra(insumoDTO.getFecha_compra());

        // Guardar en BD
        Insumo insumoActualizado = insumoService.guardarInsumo(insumoExistente);

        // Devolver DTO
        return ResponseEntity.ok(convertEntityToDTO(insumoActualizado));
    }

    // ========== ELIMINAR ==========
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTrabajo(@PathVariable Integer id) {
        if (!insumoService.obtenerInsumoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        insumoService.eliminarInsumo(id);
        return ResponseEntity.noContent().build();
    }

    // ========== MÉTODOS DE CONVERSIÓN ==========

    private InsumoDTO convertEntityToDTO(Insumo insumo) {
        InsumoDTO dto = new InsumoDTO();
        dto.setId(insumo.getId());
        dto.setNombre(insumo.getNombre());
        dto.setDescripcion(insumo.getDescripcion());
        dto.setStock(insumo.getStock());
        dto.setCosto_unitario(insumo.getCosto_unitario());
        dto.setFecha_compra(insumo.getFecha_compra());
        return dto;
    }

    private Insumo convertDTOToEntity(InsumoDTO dto) {
        Insumo insumo = new Insumo();
        insumo.setId(dto.getId());
        insumo.setNombre(dto.getNombre());
        insumo.setDescripcion(dto.getDescripcion());
        insumo.setStock(dto.getStock());
        insumo.setCosto_unitario(dto.getCosto_unitario());
        insumo.setFecha_compra(dto.getFecha_compra());
        return insumo;
    }
}
