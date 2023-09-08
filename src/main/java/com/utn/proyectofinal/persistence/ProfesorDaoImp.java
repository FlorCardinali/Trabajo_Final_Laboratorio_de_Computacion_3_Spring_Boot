package com.utn.proyectofinal.persistence;
import com.utn.proyectofinal.model.Profesor;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ProfesorDaoImp implements ProfesorDao{

    private static final Map<Long, Profesor> repositorioProfesores = new HashMap<>();
    @Override
    public void guardarProfesor(Profesor p) {
        Random id = new Random();
        p.setId(id.nextLong());
        repositorioProfesores.put(p.getId(),p);
    }

    @Override
    public Profesor buscarProfesorPorId(Long id) throws Error_Profesor_No_Encontrado {
        for (Profesor p: repositorioProfesores.values()) {
            if (id == p.getId()) {
                return p;
            }
        }
        throw new Error_Profesor_No_Encontrado("No existe un profesor con esa ID");
    }

    @Override
    public void modificarProfesor(Profesor p) {

    }
}
