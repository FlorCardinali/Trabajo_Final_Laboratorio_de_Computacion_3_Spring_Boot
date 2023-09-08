package com.utn.proyectofinal.business;

import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Correlatividad_No_Aprobada;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;

public interface AlumnoService {

    void aprobarAsignatura(int materiaId, int nota, long dni) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente, Error_Correlatividad_No_Aprobada, Error_Asignatura_No_encontrada;

    Alumno crearAlumno(AlumnoDto alumno);

    Alumno buscarAlumnoPorApellido(String apellidoAlumno);
}
