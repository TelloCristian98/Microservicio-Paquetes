package com.espe.micro_cursos.controllers;

import com.espe.micro_cursos.model.entity.PaqueteTuristico;
import com.espe.micro_cursos.services.PaqueteTuristicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/paquetes")
public class PaqueteTuristicoController {

    @Autowired
    private PaqueteTuristicoService service;

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody PaqueteTuristico paquete, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(paquete));
    }

    @GetMapping
    public List<PaqueteTuristico> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscar(@PathVariable Integer id) {
        return service.findById(id)
                .map(paquete -> ResponseEntity.ok().body(paquete))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Integer id, @Valid @RequestBody PaqueteTuristico paquete, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        return service.findById(id).map(existing -> {
            existing.setNombre(paquete.getNombre());
            existing.setDescripcion(paquete.getDescripcion());
            existing.setDuracionDias(paquete.getDuracionDias());
            existing.setFechaInicio(paquete.getFechaInicio());
            return ResponseEntity.ok().body(service.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        return service.findById(id).map(paquete -> {
            service.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}