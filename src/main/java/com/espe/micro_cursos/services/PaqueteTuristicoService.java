package com.espe.micro_cursos.services;


import com.espe.micro_cursos.model.entity.PaqueteTuristico;

import java.util.List;
import java.util.Optional;

public interface PaqueteTuristicoService {
    List<PaqueteTuristico> findAll();
    Optional<PaqueteTuristico> findById(Integer id);
    PaqueteTuristico save(PaqueteTuristico paqueteTuristico);
    void deleteById(Integer id);
}