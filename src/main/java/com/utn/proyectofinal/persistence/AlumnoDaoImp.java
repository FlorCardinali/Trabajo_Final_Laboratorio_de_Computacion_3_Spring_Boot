package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AlumnoDaoImp implements AlumnoDao{

    //esta es "la base de datos" donde se guardan los alumnos
    private static final Map<Long, Alumno> RepositorioAlumnos = new HashMap<>();
    long id = 1;
    @Override
    public void GuardarAlumno(Alumno a) {
        a.setId(this.id);
        this.id++;
        RepositorioAlumnos.put(a.getDni(),a);
        //no veo necesario que devuelva nada, quizas un ok..
    }

    @Override
    public Alumno actualizarAlumno(Alumno a) throws Error_Alumno_No_Encontrado {
        for (Alumno al : RepositorioAlumnos.values()) {
            if (al.getId() == a.getId()) {
                RepositorioAlumnos.put(a.getDni(), a);
                return a;
            }
        }
        throw new Error_Alumno_No_Encontrado("No se puede modificar, el alumno no existe aun.");
    }

    @Override
    public Alumno eliminarAlumno(long id) throws Error_Alumno_No_Encontrado {
        for (Alumno a: RepositorioAlumnos.values()){
            if (a.getId() == id){
                RepositorioAlumnos.remove(a.getDni());
                return a;
            }
        }
        throw new Error_Alumno_No_Encontrado("No se pudo eliminar, alumno no encotnrado");
    }


    @Override
    public Alumno BuscarAlumnoPorApellido(String apellidoAlumno_p) throws Error_Alumno_No_Encontrado {
        for (Alumno al: RepositorioAlumnos.values()) {
            if (al.getApellido().equals(apellidoAlumno_p)){
                return al;
            }
        }
        throw new Error_Alumno_No_Encontrado("El apellido "+apellidoAlumno_p+" no coincide con ningun alumno.");
    }

    @Override
    public Alumno BuscarAlumnoPorDni(long dni) throws Error_Alumno_No_Encontrado {
        for (Alumno al: RepositorioAlumnos.values()) {
            if (al.getDni()==dni){
                return al;
            }
        }
        throw new Error_Alumno_No_Encontrado("El dni no pertence a ningun alumno");
    }

    @Override
    public Alumno BuscarAlumnoPorId(long id) throws Error_Alumno_No_Encontrado {
        for (Alumno al: RepositorioAlumnos.values()) {
            if (al.getId()==id){
                return al;
            }
        }
        throw new Error_Alumno_No_Encontrado("No se encontro un alumno con id " + id);
    }
}
