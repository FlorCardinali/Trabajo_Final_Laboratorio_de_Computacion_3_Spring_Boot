package com.utn.proyectofinal.business.imp;

import com.utn.proyectofinal.business.AsignaturaService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.EstadoAsignatura;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Correlatividad_No_Aprobada;
import com.utn.proyectofinal.persistence.AlumnoDao;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImp implements AsignaturaService {
    @Autowired
    private AlumnoDao alumnoDao;

    @Override
    public Asignatura getAsignaturaAlumno(long materiaId, long dni) throws Error_Asignatura_No_encontrada, Error_Alumno_No_Encontrado {
        Alumno a = alumnoDao.BuscarAlumnoPorDni(dni);
        return a.getAsignaturaPorIdMateria(materiaId);
    }

    @Override
    public Asignatura actualizarAsignatura(Asignatura a) {
        return null;
    }

    @Override
    public boolean comprobnarCorrelativas(int materiaId, long dni) throws Error_Asignatura_No_encontrada, Error_Alumno_No_Encontrado, Error_Correlatividad_No_Aprobada {
        Asignatura a = this.getAsignaturaAlumno(materiaId, dni);
        for (Materia m: a.getMateria().getCorrelatividades()) {
            Asignatura cor = this.getAsignaturaAlumno(m.getId(), dni);
            if (!EstadoAsignatura.APROBADA.equals(cor.getEstado())) {
                throw new Error_Correlatividad_No_Aprobada("La materia " + m.getNombre() + " debe estar aprobada para aprobar " + a.getMateria().getNombre());
            }
        }
        return true;
    }

}
