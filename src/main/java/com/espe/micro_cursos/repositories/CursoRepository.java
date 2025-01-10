package com.espe.micro_cursos.repositories;

import com.espe.micro_cursos.model.entity.Cursos;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Cursos, Long> {
}
