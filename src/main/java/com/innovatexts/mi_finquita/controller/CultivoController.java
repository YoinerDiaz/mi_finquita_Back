package com.innovatexts.mi_finquita.controller;

import com.innovatexts.mi_finquita.model.Cultivo;
import com.innovatexts.mi_finquita.service.CultivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cultivos")
@CrossOrigin(origins = "*") // Permite acceso desde cualquier dominio
public class CultivoController {

    @Autowired
    private CultivoService cultivoService;

    // Endpoint para guardar un cultivo
    @PostMapping
    public ResponseEntity<Cultivo> guardarCultivo(@RequestBody Cultivo cultivo) {
        Cultivo nuevoCultivo = cultivoService.guardarCultivo(cultivo);
        return ResponseEntity.ok(nuevoCultivo);
    }

    // Endpoint para obtener todos los cultivos
    @GetMapping
    public ResponseEntity<List<Cultivo>> obtenerTodosLosCultivos() {
        List<Cultivo> cultivos = cultivoService.obtenerTodosLosCultivos();
        return ResponseEntity.ok(cultivos);
    }

    // Endpoint para obtener un cultivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cultivo> obtenerCultivoPorId(@PathVariable Integer id) {
        Optional<Cultivo> cultivo = cultivoService.obtenerCultivoPorId(id);
        return cultivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para actualizar un cultivo
    @PutMapping("/{id}")
    public ResponseEntity<Cultivo> actualizarCultivo(@PathVariable Integer id, @RequestBody Cultivo cultivo) {
        Cultivo cultivoActualizado = cultivoService.actualizarCultivo(id, cultivo);
        if (cultivoActualizado != null) {
            return ResponseEntity.ok(cultivoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
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
}
