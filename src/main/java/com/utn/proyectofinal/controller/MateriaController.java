package com.utn.proyectofinal.controller;


import com.utn.proyectofinal.business.MateriaService;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.dto.MateriaDto;
import com.utn.proyectofinal.persistence.exeptions.Error_Materia_No_Encontrada;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public List<Materia> getMaterias() {
        return materiaService.getAllMaterias();
    }

    @PostMapping
    public Materia crearMateria(@RequestBody MateriaDto materiaDto) throws Error_Profesor_No_Encontrado {
        return materiaService.crearMateria(materiaDto);
    }

    @GetMapping("/{idMateria}")
    public Materia getMateriaById(@PathVariable Integer idMateria) throws Error_Materia_No_Encontrada {
        return materiaService.getMateriaById(idMateria);
    }
}