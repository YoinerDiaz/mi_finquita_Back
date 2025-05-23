package com.innovatexts.mi_finquita.service;

import com.innovatexts.mi_finquita.model.Cultivo;
import com.innovatexts.mi_finquita.repository.CultivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CultivoService {

    @Autowired
    private CultivoRepository cultivoRepository;

    public long obtenerTotalRegistros() {
        return cultivoRepository.contarRegistros();
    }

    // Guardar un cultivo
    public Cultivo guardarCultivo(Cultivo cultivo) {
        return cultivoRepository.save(cultivo);
    }

    // Obtener todos los cultivos
    public List<Cultivo> obtenerTodosLosCultivos() {
        return cultivoRepository.findAll();
    }

    // Obtener un cultivo por su ID
    public Optional<Cultivo> obtenerCultivoPorId(Integer id) {
        return cultivoRepository.findById(id);
    }

    // Actualizar un cultivo
    public Cultivo actualizarCultivo(Integer id, Cultivo cultivoActualizado) {
        return cultivoRepository.findById(id).map(cultivo -> {
            cultivo.setNombre(cultivoActualizado.getNombre());
            cultivo.setDescripcion(cultivoActualizado.getDescripcion());
            cultivo.setTipo(cultivoActualizado.getTipo());
            cultivo.setVariedad(cultivoActualizado.getVariedad());
            cultivo.setFechaSiembra(cultivoActualizado.getFechaSiembra());
            cultivo.setFechaCosecha(cultivoActualizado.getFechaCosecha());
            cultivo.setAreaHectareas(cultivoActualizado.getAreaHectareas());
            cultivo.setUbicacion(cultivoActualizado.getUbicacion());
            cultivo.setEstado(cultivoActualizado.getEstado());
            return cultivoRepository.save(cultivo);
        }).orElse(null);
    }

    // Eliminar un cultivo
    public boolean eliminarCultivo(Integer id) {
        if (cultivoRepository.existsById(id)) {
            cultivoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
