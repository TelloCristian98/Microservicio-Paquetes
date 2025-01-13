package com.espe.micro_cursos.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "paquetes_turisticos")
public class PaqueteTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombre;

    @Column(nullable = false)
    @NotEmpty(message = "La descripción no puede estar vacía")
    private String descripcion;

    @Column(nullable = false)
    @Min(value = 1, message = "La duración debe ser al menos 1 día")
    private int duracionDias;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @FutureOrPresent(message = "La fecha de inicio debe ser en el futuro o presente")
    private Date fechaInicio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotEmpty(message = "El nombre no puede estar vacío") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotEmpty(message = "El nombre no puede estar vacío") String nombre) {
        this.nombre = nombre;
    }

    public @NotEmpty(message = "La descripción no puede estar vacía") String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@NotEmpty(message = "La descripción no puede estar vacía") String descripcion) {
        this.descripcion = descripcion;
    }

    @Min(value = 1, message = "La duración debe ser al menos 1 día")
    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(@Min(value = 1, message = "La duración debe ser al menos 1 día") int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public @FutureOrPresent(message = "La fecha de inicio debe ser en el futuro o presente") Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(@FutureOrPresent(message = "La fecha de inicio debe ser en el futuro o presente") Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
}