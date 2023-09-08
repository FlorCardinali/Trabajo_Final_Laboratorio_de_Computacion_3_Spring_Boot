package com.utn.proyectofinal.model.dto;

public class MateriaDto {
    private String nombre;
    private int anio;
    private int cuatrimestre;
    private long profesorId;

    //getters
    public String getNombre() {
        return nombre;
    }
    public int getAnio() {
        return anio;
    }
    public int getCuatrimestre() {
        return cuatrimestre;
    }
    public long getProfesorId() {
        return profesorId;
    }


    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
    public void setProfesorId(long profesorId) {
        this.profesorId = profesorId;
    }
}
