package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Profesor;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProfesorDaoImp implements ProfesorDao {

    private static final Map<Long, Profesor> repositorioProfesores = new HashMap<>();
    long id = 1;


    @Override
    public void guardarProfesor(Profesor p) {
        p.setId(this.id);
        this.id++;
        repositorioProfesores.put(p.getId(), p);
    }

    @Override
    public Profesor buscarProfesorPorId(Long id) throws Error_Profesor_No_Encontrado {
        for (Profesor p : repositorioProfesores.values()) {
            if (id == p.getId()) {
                return p;
            }
        }
        throw new Error_Profesor_No_Encontrado("No existe un profesor con esa ID");
    }

    @Override
    public Profesor buscarProfesorPorApellido(String apellido) throws Error_Profesor_No_Encontrado {
        for (Profesor p : repositorioProfesores.values()) {
            if (apellido.equals(p.getApellido())) {
                return p;
            }
        }
        throw new Error_Profesor_No_Encontrado("No existe un profesor con ese Apellido");
    }

    @Override
    public Profesor actualizarProfesor(Profesor p) throws Error_Profesor_No_Encontrado {
        for (Profesor pr : repositorioProfesores.values()) {
            if (pr.getId() == p.getId()) {
                repositorioProfesores.put(p.getId(), p);
                return p;
            }
        }
        throw new Error_Profesor_No_Encontrado("No se puede modificar, el profesor no existe aun.");
    }

    @Override
    public boolean elimiarProfesor(long id) throws Error_Profesor_No_Encontrado {
        Profesor p = this.buscarProfesorPorId(id);
        if (p!=null){
            repositorioProfesores.remove(id);
            return true;
        }
        return false;
    }


}
