package com.utn.proyectofinal.model;

import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;

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

    public void cursarAsignatura(Asignatura asignatura_p){
        if (asignatura_p.getEstado()!=EstadoAsignatura.CURSADA){
            asignatura_p.setEstado(EstadoAsignatura.CURSADA);
            this.asignaturas.add(asignatura_p);
        }
    }

    public Asignatura aprobarAsignatura(long materiaId, int nota) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente, Error_Asignatura_No_encontrada {
        for (Asignatura a: asignaturas){
            if (a.getMateria().getId() == materiaId){
                asignaturas.remove(a);
                a.aprobarAsignatura(nota);
                asignaturas.add(a);
                return a;
            }
        }
        Asignatura as = getAsignaturaPorIdMateria(materiaId);
        throw new Error_Asignatura_No_encontrada("El alumno no cursa " + as.getMateria().getNombre());
    }

}
