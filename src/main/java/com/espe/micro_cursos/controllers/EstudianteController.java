package com.espe.micro_cursos.controllers;

import com.espe.micro_cursos.model.entity.Estudiantes;
import com.espe.micro_cursos.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Estudiantes estudiante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteService.save(estudiante));
    }

    @GetMapping
    public List<Estudiantes> listar() {
        return estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Estudiantes> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            return ResponseEntity.ok().body(estudiante.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Estudiantes estudiante) {
        Optional<Estudiantes> estudianteExistente = estudianteService.findById(id);
        if (estudianteExistente.isPresent()) {
            Estudiantes estudianteActual = estudianteExistente.get();
            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setApellido(estudiante.getApellido());
            estudianteActual.setEmail(estudiante.getEmail());
            estudianteActual.setFechaNacimiento(estudiante.getFechaNacimiento());
            estudianteActual.setTelefono(estudiante.getTelefono());
            return ResponseEntity.ok().body(estudianteService.save(estudianteActual));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Estudiantes> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            estudianteService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}