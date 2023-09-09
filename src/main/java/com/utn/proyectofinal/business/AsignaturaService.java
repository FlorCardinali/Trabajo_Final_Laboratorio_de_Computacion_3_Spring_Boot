package com.utn.proyectofinal.business;

import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;

public interface AsignaturaService {

    Asignatura getAsignaturaAlumno(long materiaId, long dni) throws Error_Asignatura_No_encontrada, Error_Alumno_No_Encontrado;

}
