package com.utn.proyectofinal.business.imp;

import com.utn.proyectofinal.business.AlumnoService;
import com.utn.proyectofinal.business.AsignaturaService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.EstadoAsignatura;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Correlatividad_No_Aprobada;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;
import com.utn.proyectofinal.persistence.AlumnoDao;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoDao alumnoDao;
    @Autowired
    private AsignaturaService asignaturaService;


    @Override
    public void aprobarAsignatura(int materiaId, int nota, long dni) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente, Error_Correlatividad_No_Aprobada, Error_Asignatura_No_encontrada, Error_Alumno_No_Encontrado {

        Asignatura a = asignaturaService.getAsignaturaAlumno(materiaId, dni);
        for (Materia m: a.getMateria().getCorrelatividades()) {
            Asignatura cor = asignaturaService.getAsignaturaAlumno(m.getId(), dni);
            if (!EstadoAsignatura.APROBADA.equals(cor.getEstado())) {
                throw new Error_Correlatividad_No_Aprobada("La materia " + m.getNombre() + " debe estar aprobada para aprobar " + a.getMateria().getNombre());
            }
        }
        a.setAprobarAsignatura(nota);
        //asignaturaService.actualizarAsignatura(a);
        Alumno alumno = alumnoDao.BuscarAlumnoPorDni(dni);
        alumno.actualizarAsignatura(a);
        alumnoDao.GuardarAlumno(alumno);
    }


    @Override
    public Alumno crearAlumno(AlumnoDto alumno) {
        Alumno a = new Alumno();
        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setDni(alumno.getDni());
        Random random = new Random();
        a.setId(random.nextLong());
        alumnoDao.GuardarAlumno(a);
        return a;
    }

    @Override
    public Alumno actualizarAlumno(AlumnoDto a, long id) throws Error_Alumno_No_Encontrado {
        Alumno al = buscarAlumnoPorId(id);
        al.setApellido(a.getApellido());
        al.setNombre(a.getNombre());
        al.setDni(a.getDni());
        return alumnoDao.actualizarAlumno(al);
    }

    @Override
    public Alumno eliminarAlumno(long id) throws Error_Alumno_No_Encontrado {
         return alumnoDao.eliminarAlumno(id);
    }

    @Override
    public Alumno buscarAlumnoPorApellido(String apellidoAlumno) throws Error_Alumno_No_Encontrado {
        return alumnoDao.BuscarAlumnoPorApellido(apellidoAlumno);
    }

    @Override
    public Alumno buscarAlumnoPorId(long id) throws Error_Alumno_No_Encontrado {
        return alumnoDao.BuscarAlumnoPorId(id);
    }
}
