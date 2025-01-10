package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.Estudiantes;
import com.espe.micro_cursos.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImplement implements EstudianteService {
    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiantes> findAll() {
        return (List<Estudiantes>) estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiantes> findById(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiantes save(Estudiantes estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }
}