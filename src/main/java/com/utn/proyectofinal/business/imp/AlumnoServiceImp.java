package com.utn.proyectofinal.business.imp;

import com.utn.proyectofinal.business.AlumnoService;
import com.utn.proyectofinal.business.AsignaturaService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.EstadoAsignatura;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;
import com.utn.proyectofinal.persistence.AlumnoDao;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AlumnoServiceImp implements AlumnoService {

    @Autowired
    private AlumnoDao alumnoDao;
    @Autowired
    private AsignaturaService asignaturaService;


    @Override
    public Asignatura agregarAsignatura(Asignatura a, long idAlumno) throws Error_Alumno_No_Encontrado, Error_Estado_Incorrecto {
        Alumno al = alumnoDao.BuscarAlumnoPorId(idAlumno);
        al.agregarAsignatura(a);
        return a;
    }

    @Override
    public Asignatura modificarAsignatura(Asignatura a,long idAsignatura, long idAlumno) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente, Error_Alumno_No_Encontrado, Error_Asignatura_No_encontrada {
        EstadoAsignatura e = a.getEstado();
        int nota = a.getNota();
        Alumno al = buscarAlumnoPorId(idAlumno);
        for (Asignatura asignatura :al.getAsignaturas()){
            if (asignatura.getIdAsigantura() == idAsignatura){
                if (e==EstadoAsignatura.CURSADA){
                    asignatura.cursarAsignatura();
                    al.actualizarAsignatura(asignatura);
                    return asignatura;
                } else if (e==EstadoAsignatura.APROBADA){
                    asignatura.aprobarAsignatura(nota);
                    al.actualizarAsignatura(asignatura);
                    return asignatura;
                }
            }
        }
        throw new Error_Asignatura_No_encontrada("el alumno "+ al.getNombre() +" " + al.getApellido() + "No posee la asignatura.");
    }


    @Override
    public Alumno crearAlumno(AlumnoDto alumno) {
        Alumno a = new Alumno();
        a.setNombre(alumno.getNombre());
        a.setApellido(alumno.getApellido());
        a.setDni(alumno.getDni());
        return alumnoDao.GuardarAlumno(a);
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
