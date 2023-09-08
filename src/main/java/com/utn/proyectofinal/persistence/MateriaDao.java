package com.utn.proyectofinal.persistence;

import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.persistence.exeptions.Error_Materia_No_Encontrada;

import java.util.List;

public interface MateriaDao {
    void GuardarMateria(Materia m);
    Materia BuscarMateriaPorId(int idMateria) throws Error_Materia_No_Encontrada;
    List<Materia> ObtenerTodasLasMaterias();
}
