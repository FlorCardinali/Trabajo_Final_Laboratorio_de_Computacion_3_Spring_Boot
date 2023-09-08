package com.utn.proyectofinal.business;

import com.utn.proyectofinal.model.Asignatura;

public interface AsignaturaService {

    Asignatura getAsignatura(long materiaId, long dni);

    void actualizarAsignatura(Asignatura a);
}
