package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Alumno;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AlumnoDaoImp implements AlumnoDao{

    //esta es "la base de datos" donde se guardan los alumnos
    private static Map<Long, Alumno> RepositorioAlumnos = new HashMap<>();

    @Override
    public void GuardarAlumno(Alumno a) {
        Random id = new Random();
        a.setId(id.nextLong());
        RepositorioAlumnos.put(a.getDni(),a);
        //no veo necesario que devuelva nada, quizas un ok..
    }

    @Override
    public Alumno BuscarAlumnoPorApellido(String apellidoAlumno_p) {
        for (Alumno a: RepositorioAlumnos.values()) {
            if (a.getApellido().equals(apellidoAlumno_p)){
                return a;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "No existe ese apellido en los registros de alumnos."
        );
    }
}
