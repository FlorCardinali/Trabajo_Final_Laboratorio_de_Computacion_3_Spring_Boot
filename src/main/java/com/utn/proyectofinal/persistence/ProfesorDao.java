package com.utn.proyectofinal.persistence;
import com.utn.proyectofinal.model.Profesor;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;

public interface ProfesorDao {

    void guardarProfesor(Profesor p);
    Profesor buscarProfesorPorId(Long id) throws Error_Profesor_No_Encontrado;
    void modificarProfesor(Profesor p);
}
