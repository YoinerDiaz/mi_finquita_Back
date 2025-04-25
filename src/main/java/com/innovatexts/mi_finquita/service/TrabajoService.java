package com.innovatexts.mi_finquita.service;

import com.innovatexts.mi_finquita.model.Trabajo;
import com.innovatexts.mi_finquita.repository.TrabajoRepository;

import jakarta.transaction.Transactional;

import com.innovatexts.mi_finquita.repository.TrabajoCultivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajoService {

    private final TrabajoRepository trabajoRepository;
    private final TrabajoCultivoRepository trabajoCultivoRepository;

    @Autowired
    public TrabajoService(TrabajoRepository trabajoRepository, TrabajoCultivoRepository trabajoCultivoRepository) {
        this.trabajoRepository = trabajoRepository;
        this.trabajoCultivoRepository = trabajoCultivoRepository;
    }
    public List<Trabajo> listarTrabajos() {
        return trabajoRepository.findAll();
    }

    public Optional<Trabajo> obtenerTrabajoPorId(int id) {
        return trabajoRepository.findById(id);
    }

    public Trabajo guardarTrabajo(Trabajo trabajo) {
        return trabajoRepository.save(trabajo);
    }

    @Transactional
    public void eliminarTrabajo(int id) {
        trabajoCultivoRepository.deleteById(id);
        trabajoRepository.deleteById(id);
    }
}
