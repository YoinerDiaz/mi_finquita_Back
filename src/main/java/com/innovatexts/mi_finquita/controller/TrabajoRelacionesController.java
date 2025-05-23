package com.innovatexts.mi_finquita.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovatexts.mi_finquita.dto.TrabajoCultivoDTO;
import com.innovatexts.mi_finquita.dto.TrabajoInsumoDTO;
import com.innovatexts.mi_finquita.model.Cultivo;
import com.innovatexts.mi_finquita.model.Insumo;
import com.innovatexts.mi_finquita.model.Trabajo;
import com.innovatexts.mi_finquita.model.TrabajoCultivo;
import com.innovatexts.mi_finquita.model.TrabajoInsumo;
import com.innovatexts.mi_finquita.repository.CultivoRepository;
import com.innovatexts.mi_finquita.repository.InsumoRepository;
import com.innovatexts.mi_finquita.repository.TrabajoCultivoRepository;
import com.innovatexts.mi_finquita.repository.TrabajoInsumoRepository;
import com.innovatexts.mi_finquita.repository.TrabajoRepository;

@RestController
@RequestMapping("/api/relaciones")
public class TrabajoRelacionesController {

    private final TrabajoRepository trabajoRepository;
    private final CultivoRepository cultivoRepository;
    private final InsumoRepository insumoRepository;
    private final TrabajoCultivoRepository trabajoCultivoRepository;
    private final TrabajoInsumoRepository trabajoInsumoRepository;

    public TrabajoRelacionesController(
        TrabajoRepository trabajoRepository,
        CultivoRepository cultivoRepository,
        InsumoRepository insumoRepository,
        TrabajoCultivoRepository trabajoCultivoRepository,
        TrabajoInsumoRepository trabajoInsumoRepository
    ) {
        this.trabajoRepository = trabajoRepository;
        this.cultivoRepository = cultivoRepository;
        this.insumoRepository = insumoRepository;
        this.trabajoCultivoRepository = trabajoCultivoRepository;
        this.trabajoInsumoRepository = trabajoInsumoRepository;
    }

    // ========== POST: Insertar en trabajo_cultivo ==========
    @PostMapping("/trabajo-cultivo")
    public ResponseEntity<TrabajoCultivoDTO> crearTrabajoCultivo(@RequestBody TrabajoCultivoDTO dto) {
        // 1. Buscar Trabajo
        Trabajo trabajo = trabajoRepository.findById(dto.getTrabajoId())
            .orElseThrow(() -> new RuntimeException("Trabajo no encontrado con ID: " + dto.getTrabajoId()));

        // 2. Buscar Cultivo
        Cultivo cultivo = cultivoRepository.findById(dto.getCultivoId())
            .orElseThrow(() -> new RuntimeException("Cultivo no encontrado con ID: " + dto.getCultivoId()));

        // 3. Crear objeto intermedio
        TrabajoCultivo trabajoCultivo = new TrabajoCultivo();
        trabajoCultivo.setTrabajo(trabajo);
        trabajoCultivo.setCultivo(cultivo);

        // 4. Guardar en la BD
        trabajoCultivoRepository.save(trabajoCultivo);

        TrabajoCultivoDTO responseDTO = new TrabajoCultivoDTO(
        trabajo.getDetalles(),
        cultivo.getNombre()
    );
        
        // 5. Retornar respuesta
        return ResponseEntity.ok(responseDTO);
    }

    // ========== POST: Insertar en trabajo_insumo ==========
    @PostMapping("/trabajo-insumo")
    public ResponseEntity<TrabajoInsumo> crearTrabajoInsumo(@RequestBody TrabajoInsumoDTO dto) {
        // 1. Buscar Trabajo
        Trabajo trabajo = trabajoRepository.findById(dto.getTrabajoId())
            .orElseThrow(() -> new RuntimeException("Trabajo no encontrado con ID: " + dto.getTrabajoId()));

        // 2. Buscar Insumo
        Insumo insumo = insumoRepository.findById(dto.getInsumoId())
            .orElseThrow(() -> new RuntimeException("Insumo no encontrado con ID: " + dto.getInsumoId()));

        // 3. Crear objeto intermedio
        TrabajoInsumo trabajoInsumo = new TrabajoInsumo();
        trabajoInsumo.setTrabajo(trabajo);
        trabajoInsumo.setInsumo(insumo);
        trabajoInsumo.setCantidad(dto.getCantidad());
        trabajoInsumo.setCostoUnitario(dto.getCostoUnitario());

        // 4. Guardar en la BD
        trabajoInsumoRepository.save(trabajoInsumo);

        // 5. Retornar respuesta
        return ResponseEntity.ok(null);
    }
}
