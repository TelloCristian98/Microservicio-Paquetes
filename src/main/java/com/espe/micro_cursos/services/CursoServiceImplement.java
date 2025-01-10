package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Cursos;
import com.espe.micro_cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImplement implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Cursos> findAll() {
        return (List<Cursos>) cursoRepository.findAll();
    }

    @Override
    public Optional<Cursos> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public Cursos save(Cursos curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}
