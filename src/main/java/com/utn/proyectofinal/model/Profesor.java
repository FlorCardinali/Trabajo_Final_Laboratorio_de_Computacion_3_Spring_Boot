package com.utn.proyectofinal.model;

public class Profesor {
    private long id;
    private String nombre;
    private String apellido;
    private String titulo;

    //constructor
    public Profesor(){};

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
    public String getTitulo() {
        return titulo;
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
    public void setTitulo(String titulo_p) {
        this.titulo = titulo_p;
    }
}
