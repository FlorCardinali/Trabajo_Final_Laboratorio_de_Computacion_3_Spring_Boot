package com.utn.proyectofinal.model;

import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    //id de la db
    private long id;

    //atributos del propio concepto
    private String nombre;
    private String apellido;
    private long dni;

    // atributo para lasa asignaturas que este alumno cursa.
    private List<Asignatura> asignaturas;


    //constructores
    public Alumno(){}
    public Alumno(String nombre_p, String apellido_p, long dni_p) {
        this.nombre = nombre_p;
        this.apellido = apellido_p;
        this.dni = dni_p;
        asignaturas = new ArrayList<>();
    }

    //getters

    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public long getDni() {
        return dni;
    }
    public List<Asignatura> getAsignaturas(){ //c
        return this.asignaturas;
    }
    public Asignatura getAsignaturaPorIdMateria(long idMateria) throws Error_Asignatura_No_encontrada {
        for (Asignatura a: asignaturas){
            if (a.getMateria().getId() == idMateria){
                return a;
            }
        }
        throw new Error_Asignatura_No_encontrada("El alumno no posee la asignatura");
    }

    //setters

    public void setId(long id_p) {
        this.id = id_p;
    }
    public void setNombre(String nombre_p) {
        this.nombre = nombre_p;
    }
    public void setApellido(String apellido_p) {
        this.apellido = apellido_p;
    }
    public void setDni(long dni_p) {
        this.dni = dni_p;
    }


    //setters especiales

    public void agregarAsignatura(Asignatura asignatura_p){
        this.asignaturas.add(asignatura_p);
    }
    public void actualizarAsignatura(Asignatura asignatura_p){
        for (Asignatura a: asignaturas) {
            if (a.getMateria().getNombre().equals(asignatura_p.getMateria().getNombre())) {
                a.setEstado(asignatura_p.getEstado());
                a.setNota(asignatura_p.getNota().get());
            }
        }
    }
}
