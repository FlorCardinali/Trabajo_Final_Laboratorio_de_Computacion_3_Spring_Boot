package com.utn.proyectofinal.model.dto;

public class ProfesorDto {
    private String nombre;
    private String apellido;
    private String titulo;


    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    //Getters

    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getTitulo() {
        return titulo;
    }

}
