package com.espe.micro_cursos.controllers;

import com.espe.micro_cursos.model.entity.Cursos;
import com.espe.micro_cursos.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Cursos curso, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getAllErrors().forEach(error -> errores.put(error.getDefaultMessage(), error.getDefaultMessage()));
            return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(curso));
    }

    @GetMapping
    public List<Cursos> listar() {
        return cursoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        Optional<Cursos> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok().body(curso.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Cursos curso) {
        Optional<Cursos> cursoExistente = cursoService.findById(id);
        if (cursoExistente.isPresent()) {
            Cursos cursoAtual = cursoExistente.get();
            cursoAtual.setNombre(curso.getNombre());
            cursoAtual.setDescripcion(curso.getDescripcion());
            cursoAtual.setCreditos(curso.getCreditos());
            return ResponseEntity.ok().body(cursoService.save(cursoAtual));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Cursos> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            cursoService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }
}
