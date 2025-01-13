package com.espe.micro_cursos.services;

import com.espe.micro_cursos.model.entity.PaqueteTuristico;
import com.espe.micro_cursos.repositories.PaqueteTuristicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaqueteTuristicoServiceImpl implements PaqueteTuristicoService {

    @Autowired
    private PaqueteTuristicoRepository repository;

    @Override
    public List<PaqueteTuristico> findAll() {
        return (List<PaqueteTuristico>) repository.findAll();
    }

    @Override
    public Optional<PaqueteTuristico> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public PaqueteTuristico save(PaqueteTuristico paqueteTuristico) {
        return repository.save(paqueteTuristico);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
