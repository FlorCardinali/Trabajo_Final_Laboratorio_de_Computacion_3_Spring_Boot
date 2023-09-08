package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.persistence.exeptions.Error_Materia_No_Encontrada;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MateriaDaoImp implements MateriaDao{

    private static final Map<Long, Materia> repositorioMaterias = new HashMap<>();
    @Override
    public void GuardarMateria(Materia m) {
        Random id = new Random();
        m.setId(id.nextLong());
        repositorioMaterias.put(m.getId(),m);
    }

    @Override
    public Materia BuscarMateriaPorId(int idMateria) throws Error_Materia_No_Encontrada {
        for (Materia m: repositorioMaterias.values()) {
            if (idMateria == m.getId()) {
                return m;
            }
        }
        throw new Error_Materia_No_Encontrada("No se encontró la materia con id " + idMateria);
    }
}
