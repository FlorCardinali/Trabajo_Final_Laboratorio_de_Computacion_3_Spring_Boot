package com.utn.proyectofinal.business.imp;

import com.utn.proyectofinal.business.MateriaService;
import com.utn.proyectofinal.business.ProfesorService;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.Profesor;
import com.utn.proyectofinal.model.dto.ProfesorDto;
import com.utn.proyectofinal.persistence.ProfesorDao;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class ProfesorServiceImp implements ProfesorService {

    @Autowired
    private ProfesorDao profesorDao;
    @Autowired
    private MateriaService materiaService;


    @Override
    public Profesor buscarProfesorPorId(long id) throws Error_Profesor_No_Encontrado {
        return profesorDao.buscarProfesorPorId(id);
    }

    @Override
    public Profesor crearProfesor(ProfesorDto profe) {
        Profesor p = new Profesor();
        p.setNombre(profe.getNombre());
        p.setApellido(profe.getApellido());
        p.setTitulo(profe.getTitulo());
        profesorDao.guardarProfesor(p);
        return p;
    }

    @Override
    public Profesor actualizarProfesor(Profesor p,ProfesorDto profesorDto) {
        p.setNombre(profesorDto.getNombre());
        p.setApellido(profesorDto.getApellido());
        p.setTitulo(profesorDto.getTitulo());
        profesorDao.guardarProfesor(p);
        return p;
    }

    @Override
    public boolean eliminarProfesor(long id) throws Error_Profesor_No_Encontrado {
        return profesorDao.elimiarProfesor(id);
    }

    @Override
    public List<Materia> materiasProfesor(long id) {
        List<Materia> materias = materiaService.getAllMaterias();
        List<Materia> materiasProfe = new ArrayList<>();
        for (Materia m: materias){
            if (m.getProfesor().getId()==id){
                materiasProfe.add(m);
            }
        }
        Collections.sort(materiasProfe, Comparator.comparing(Materia -> Materia.getProfesor().getNombre()));
        return materiasProfe;
    }

}
