package com.innovatexts.mi_finquita.service;

import com.innovatexts.mi_finquita.model.Insumo;
import com.innovatexts.mi_finquita.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    public List<Insumo> listarInsumos() {
        return insumoRepository.findAll();
    }

    public Optional<Insumo> obtenerInsumoPorId(int id) {
        return insumoRepository.findById(id);
    }

    public Insumo guardarInsumo(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    public void eliminarInsumo(int id) {
        insumoRepository.deleteById(id);
    }
}
