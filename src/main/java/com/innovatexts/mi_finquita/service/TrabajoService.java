package com.innovatexts.mi_finquita.service;

import com.innovatexts.mi_finquita.model.Trabajo;
import com.innovatexts.mi_finquita.repository.TrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajoService {

    @Autowired
    private TrabajoRepository trabajoRepository;

    public List<Trabajo> listarTrabajos() {
        return trabajoRepository.findAll();
    }

    public Optional<Trabajo> obtenerTrabajoPorId(int id) {
        return trabajoRepository.findById(id);
    }

    public Trabajo guardarTrabajo(Trabajo trabajo) {
        return trabajoRepository.save(trabajo);
    }

    public void eliminarTrabajo(int id) {
        trabajoRepository.deleteById(id);
    }
}
