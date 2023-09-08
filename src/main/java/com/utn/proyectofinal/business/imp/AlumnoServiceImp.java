package com.utn.proyectofinal.business.imp;

import com.utn.proyectofinal.business.AlumnoService;
import com.utn.proyectofinal.business.AsignaturaService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.EstadoAsignatura;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import com.utn.proyectofinal.model.exeptions.Error_Correlatividad_No_Aprobada;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;
import com.utn.proyectofinal.persistence.AlumnoDao;
import com.utn.proyectofinal.persistence.AlumnoDaoImp;

public class AlumnoServiceImp implements AlumnoService {

    private static final AlumnoDao alumnoDao = new AlumnoDaoImp();
    private static final AsignaturaService asignaturaService = new AsignaturaServiceImp();


    @Override
    public void aprobarAsignatura(int materiaId, int nota, long dni) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente, Error_Correlatividad_No_Aprobada {
        Asignatura a = asignaturaService.getAsignatura(materiaId, dni);
        for (Materia m: a.getMateria().getCorrelatividades()) {
            Asignatura cor = asignaturaService.getAsignatura(m.getId(), dni);
            if (!EstadoAsignatura.APROBADA.equals(cor.getEstado())) {
                throw new Error_Correlatividad_No_Aprobada("La materia " + m.getNombre() + " debe estar aprobada para aprobar " + a.getMateria().getNombre());
            }
        }
        a.setAprobarAsignatura(nota);
        asignaturaService.actualizarAsignatura(a);
        Alumno alumno = alumnoDao.(dni);asdasdasdasd
        alumno.actualizarAsignatura(a);
        alumnoDao.saveAlumno(alumno);
    }

    @Override
    public Alumno crearAlumno(AlumnoDto alumno) {
        return null;
    }

    @Override
    public Alumno buscarAlumno(String apellidoAlumno) {
        return null;
    }
}
