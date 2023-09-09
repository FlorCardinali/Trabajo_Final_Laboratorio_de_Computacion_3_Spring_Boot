package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.persistence.exeptions.Error_Materia_No_Encontrada;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MateriaDaoImp implements MateriaDao{

    private static final Map<Long, Materia> repositorioMaterias = new HashMap<>();
    long id = 1;
    @Override
    public void GuardarMateria(Materia m) {
        m.setId(this.id);
        this.id++;
        repositorioMaterias.put(m.getId(),m);
    }

    @Override
    public Materia BuscarMateriaPorId(long idMateria) throws Error_Materia_No_Encontrada {
        for (Materia m: repositorioMaterias.values()) {
            if (idMateria == m.getId()) {
                return m;
            }
        }
        throw new Error_Materia_No_Encontrada("No se encontró la materia con id " + idMateria);
    }

    @Override
    public List<Materia> ObtenerTodasLasMaterias() {
        return new ArrayList<Materia>(repositorioMaterias.values());
    }

}
