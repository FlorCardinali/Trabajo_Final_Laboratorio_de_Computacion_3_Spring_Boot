package com.utn.proyectofinal.business;

import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.dto.MateriaDto;
import com.utn.proyectofinal.persistence.exeptions.Error_Materia_No_Encontrada;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;

import java.util.List;

public interface MateriaService {
    Materia crearMateria(MateriaDto materia) throws Error_Profesor_No_Encontrado;

    List<Materia> getAllMaterias();

    Materia getMateriaById(int idMateria) throws Error_Materia_No_Encontrada;
}
