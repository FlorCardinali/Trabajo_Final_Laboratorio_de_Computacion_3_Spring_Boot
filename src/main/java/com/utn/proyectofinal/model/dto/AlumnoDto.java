package com.utn.proyectofinal.model.dto;

import com.utn.proyectofinal.model.Asignatura;

import java.util.ArrayList;

public class AlumnoDto {

    String nombre;
    String apellido;
    long dni;
    ArrayList<Asignatura> asignaturas = new ArrayList<>();

    //getters
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public long getDni() {
        return dni;
    }
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

//setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }
    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
}
