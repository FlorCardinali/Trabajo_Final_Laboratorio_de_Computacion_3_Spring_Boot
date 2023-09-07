package com.utn.proyectofinal.model;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;

import java.util.Optional;
public class Asignatura {
    private Materia materia;
    private EstadoAsignatura estado;
    private int nota;

    //constructores

    public Asignatura() {
    }
    public Asignatura(Materia materia) {
        this.materia = materia;
        this.estado = EstadoAsignatura.NO_CURSADA;
    }

    //getters
    public Optional<Integer> getNota() {
        return Optional.ofNullable(nota);
    }
    public Materia getMateria() {
        return materia;
    }
    public EstadoAsignatura getEstado() {
        return estado;
    }


    //setters
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    public void setCursarEstado() {
        this.estado = EstadoAsignatura.CURSADA;
    }
    public void setAprobarAsignatura(int nota) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente {
        if (!this.estado.equals(EstadoAsignatura.CURSADA)) {
            throw new Error_Estado_Incorrecto("La materia " + this.materia.getNombre() + " aprobar debe estar cursada antes de ser aprobada.");
        }
        if (nota>=4) {
            this.estado = EstadoAsignatura.APROBADA;
            this.nota = nota;
        }else {
            throw new Error_Nota_Insuficiente("La nota debe ser cuatro o superior para aprobar la materia " + this.materia.getNombre());
        }
    }
    public void setNota(int nota) {
        this.nota = nota;
    }


}
