package com.utn.proyectofinal.model;
import java.util.ArrayList;
import java.util.List;
public class Carrera {
    private final String nombre;
    private int cantidadAnios;
    private final List<Materia> materiasList;


    //constructor
    public Carrera(String nombre_p, int cantidadAnios_p) {
        this.nombre = nombre_p;
        this.cantidadAnios = cantidadAnios_p;

        materiasList = new ArrayList<>();
    }

    //setters
    public void setAgregarMateria(Materia materia_p) {
        materiasList.add(materia_p);
    }
    public void setCantidadAnios(int cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }


    //getters
    public String getNombre() {
        return nombre;
    }
    public int getCantidadAnios() {
        return cantidadAnios;
    }
    public List<Materia> getMateriasList() {
        return materiasList;
    }
}
