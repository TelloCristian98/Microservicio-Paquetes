package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Estudiantes;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    List<Estudiantes> findAll();
    Optional<Estudiantes> findById(Long id);
    Estudiantes save(Estudiantes estudiante);
    void deleteById(Long id);
}