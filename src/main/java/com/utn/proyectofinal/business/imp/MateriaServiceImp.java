package com.utn.proyectofinal.business.imp;

import com.utn.proyectofinal.business.MateriaService;
import com.utn.proyectofinal.business.ProfesorService;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.dto.MateriaDto;
import com.utn.proyectofinal.persistence.MateriaDao;
import com.utn.proyectofinal.persistence.exeptions.Error_Materia_No_Encontrada;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Service
public class MateriaServiceImp implements MateriaService {

    @Autowired
    private MateriaDao materiaDao;
    @Autowired
    private ProfesorService profesorService;

    @Override
    public Materia crearMateria(MateriaDto materia) throws Error_Profesor_No_Encontrado, Error_Materia_No_Encontrada {
        Materia m = new Materia();
        m.setNombre(materia.getNombre());
        m.setAnio(materia.getAnio());
        m.setCuatrimestre(materia.getCuatrimestre());
        m.setProfesor(profesorService.buscarProfesorPorId(materia.getProfesorId()));
        materiaDao.GuardarMateria(m);
        m.setCorrelatividades(new ArrayList<>());
        if (materia.getCorrelatividades().size() > 0){
            for (int i : materia.getCorrelatividades()){
                m.agregarCorrelativa(materiaDao.BuscarMateriaPorId((long) i));
            }
        }
        return m;
    }

    @Override
    public List<Materia> getAllMaterias() {
        return materiaDao.ObtenerTodasLasMaterias();
    }

    @Override
    public Materia getMateriaById(int idMateria) throws Error_Materia_No_Encontrada {
        return materiaDao.BuscarMateriaPorId(idMateria);
    }

    @Override
    public List<Materia> getMateriasProfesor(long idProfe) {
        List<Materia> materias = this.getAllMaterias();
        List<Materia> materiasProfe = new ArrayList<>();
        for (Materia m: materias){
            if (m.getProfesor().getId()==idProfe){
                materiasProfe.add(m);
            }
        }
        Collections.sort(materiasProfe, Comparator.comparing(Materia -> Materia.getProfesor().getNombre()));
        return materiasProfe;
    }
}
