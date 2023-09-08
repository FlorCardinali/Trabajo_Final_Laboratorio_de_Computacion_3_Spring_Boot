package com.utn.proyectofinal.model.dto;

public class AlumnoDto {

    String nombre;
    String apellido;
    long dni;

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
}
