package com.utn.proyectofinal.business;

import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.Profesor;
import com.utn.proyectofinal.model.dto.ProfesorDto;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;

import java.util.List;

public interface ProfesorService {
    public Profesor buscarProfesorPorId(long id) throws Error_Profesor_No_Encontrado;
    public Profesor buscarProfesorPorApellido(String apellido) throws Error_Profesor_No_Encontrado;
    public Profesor crearProfesor(ProfesorDto profe);
    Profesor actualizarProfesor(Profesor p, ProfesorDto profesorDto);
    boolean eliminarProfesor(long id) throws Error_Profesor_No_Encontrado;

}
