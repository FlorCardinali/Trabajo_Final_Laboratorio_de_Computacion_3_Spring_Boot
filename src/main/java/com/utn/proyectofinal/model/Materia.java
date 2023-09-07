package com.utn.proyectofinal.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Materia {

    // atributos de bd
    private long id;

    //atributos propios del objeto
    private String nombre;
    private int anio;
    private int cuatrimestre;
    private  Profesor profesor;
    private int idDeLaMateria;


    //control de correlativas
    private List<Materia> correlatividades;


    //constructores
    public Materia(){}
    public Materia(String nombre_p, int anio_p, int cuatrimestre_p, Profesor profesor_p) {
        this.nombre = nombre_p;
        this.anio = anio_p;
        this.cuatrimestre = cuatrimestre_p;
        this.profesor = profesor_p;

        correlatividades = new ArrayList<>();
    }

    //getters
    public long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public int getAnio() {
        return anio;
    }
    public int getCuatrimestre() {
        return cuatrimestre;
    }
    public Profesor getProfesor() {
        return profesor;
    }
    public int getIdDeLaMateria() {
        return idDeLaMateria;
    }
    public List<Materia> getCorrelatividades(){
        return this.correlatividades;
    }


    //setters
    public void setId(long id_p) {
        this.id = id_p;
    }
    public void setNombre(String nombre_p) {
        this.nombre = nombre_p;
    }
    public void setAnio(int anio_p) {
        this.anio = anio_p;
    }
    public void setCuatrimestre(int cuatrimestre_p) {
        this.cuatrimestre = cuatrimestre_p;
    }
    public void setProfesor(Profesor profesor_p) {
        this.profesor = profesor_p;
    }
    public void setIdDeLaMateria(int idDeLaMateria_p) {
        this.idDeLaMateria = idDeLaMateria_p;
    }
    public void agregarCorrelativa(Materia correlativa_p){
        this.correlatividades.add(correlativa_p);
    }



    //metodos sobreescribidos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia = (Materia) o;
        return idDeLaMateria == materia.idDeLaMateria && anio == materia.anio && cuatrimestre == materia.cuatrimestre && Objects.equals(nombre, materia.nombre) && Objects.equals(profesor, materia.profesor) && Objects.equals(correlatividades, materia.correlatividades);
    }


    //sirve??
    @Override
    public int hashCode() {
        return Objects.hash(idDeLaMateria, nombre, anio, cuatrimestre, profesor, correlatividades);
    }

}



