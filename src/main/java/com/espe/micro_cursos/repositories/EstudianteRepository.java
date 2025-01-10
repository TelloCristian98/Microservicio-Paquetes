package com.espe.micro_cursos.repositories;

import com.espe.micro_cursos.model.entity.Estudiantes;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteRepository extends CrudRepository<Estudiantes, Long> {
}