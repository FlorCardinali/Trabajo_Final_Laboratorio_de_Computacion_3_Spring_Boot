package com.utn.proyectofinal.business;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Correlatividad_No_Aprobada;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;

public interface AsignaturaService {

    Asignatura getAsignaturaAlumno(long materiaId, long dni) throws Error_Asignatura_No_encontrada, Error_Alumno_No_Encontrado;
    Asignatura actualizarAsignatura(Asignatura a);
    boolean comprobnarCorrelativas(int materiaId, long dni) throws Error_Asignatura_No_encontrada, Error_Alumno_No_Encontrado, Error_Correlatividad_No_Aprobada;
}
