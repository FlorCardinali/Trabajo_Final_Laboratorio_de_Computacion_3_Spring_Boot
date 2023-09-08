package com.utn.proyectofinal.business;

import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;

public interface AsignaturaService {

    Asignatura getAsignaturaAlumno(long materiaId, long dni) throws Error_Asignatura_No_encontrada;

}
