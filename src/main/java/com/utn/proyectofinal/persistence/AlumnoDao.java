package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Alumno;

public interface AlumnoDao {
    void GuardarAlumno(Alumno a);
    Alumno BuscarAlumnoPorApellido(String apellidoAlumno);
    Alumno BuscarAlumnoPorDni(long dni);
}
