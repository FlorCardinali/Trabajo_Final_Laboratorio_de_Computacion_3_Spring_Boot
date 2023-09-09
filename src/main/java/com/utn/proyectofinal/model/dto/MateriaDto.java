package com.utn.proyectofinal.model.dto;

import java.util.List;
public class MateriaDto {
    private String nombre;
    private int anio;
    private int cuatrimestre;
    private long profesorId;
    private List<Integer> correlatividades;


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
    public List<Integer> getCorrelatividades() {
        return correlatividades;
    }

    //setters
    public void setNombre(String n){
        this.nombre = n;
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
    public void setCorrelatividades(List<Integer> correlatividades) {
        this.correlatividades = correlatividades;
    }
}
