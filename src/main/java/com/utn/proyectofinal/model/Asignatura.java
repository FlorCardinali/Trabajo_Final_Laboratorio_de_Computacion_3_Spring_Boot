package com.utn.proyectofinal.model;
import java.util.Optional;
public class Asignatura {
    private Materia materia;
    private EstadoAsignatura estado;
    private Integer nota;

    //constructores

    public Asignatura() {
    }
    public Asignatura(Materia materia) {
        this.materia = materia;
        this.estado = EstadoAsignatura.NO_CURSADA;
    }

    public Optional<Integer> getNota() {
        return Optional.ofNullable(nota);
    }
}
