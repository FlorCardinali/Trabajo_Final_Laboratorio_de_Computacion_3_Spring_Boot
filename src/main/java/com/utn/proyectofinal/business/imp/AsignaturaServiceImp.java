package com.utn.proyectofinal.business.imp;

import com.utn.proyectofinal.business.AsignaturaService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
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

}
