package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.persistence.exeptions.MateriaNotFoundException;

public interface MateriaDao {
    void GuardarMateria(Materia m);
    Materia BuscarMateriaPorId(int idMateria) throws MateriaNotFoundException;
}
