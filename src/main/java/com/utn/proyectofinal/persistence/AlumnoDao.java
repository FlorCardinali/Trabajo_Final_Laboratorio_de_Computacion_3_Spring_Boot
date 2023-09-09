package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;

public interface AlumnoDao {
    void GuardarAlumno(Alumno a);

    Alumno actualizarAlumno(Alumno a) throws Error_Alumno_No_Encontrado;
    Alumno eliminarAlumno(long id) throws Error_Alumno_No_Encontrado;
    Alumno BuscarAlumnoPorApellido(String apellidoAlumno) throws Error_Alumno_No_Encontrado;
    Alumno BuscarAlumnoPorDni(long dni) throws Error_Alumno_No_Encontrado;
    Alumno BuscarAlumnoPorId(long id) throws Error_Alumno_No_Encontrado;
}
