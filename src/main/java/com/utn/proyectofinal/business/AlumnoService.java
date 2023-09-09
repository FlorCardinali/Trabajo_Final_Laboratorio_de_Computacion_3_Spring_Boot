package com.utn.proyectofinal.business;

import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Correlatividad_No_Aprobada;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;

public interface AlumnoService {

    Asignatura aprobarAsignatura(int materiaId, int nota, long dni) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente, Error_Correlatividad_No_Aprobada, Error_Asignatura_No_encontrada, Error_Alumno_No_Encontrado;

    Alumno crearAlumno(AlumnoDto alumno);
    Alumno actualizarAlumno(AlumnoDto a, long id) throws Error_Alumno_No_Encontrado;
    Alumno eliminarAlumno(long id) throws Error_Alumno_No_Encontrado;
    Alumno buscarAlumnoPorApellido(String apellidoAlumno) throws Error_Alumno_No_Encontrado;
    Alumno buscarAlumnoPorId(long id) throws Error_Alumno_No_Encontrado;
}
