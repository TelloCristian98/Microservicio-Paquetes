package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Cursos;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Cursos> findAll();
    Optional<Cursos> findById(Long id);
    Cursos save(Cursos curso);
    void deleteById(Long id);
}
