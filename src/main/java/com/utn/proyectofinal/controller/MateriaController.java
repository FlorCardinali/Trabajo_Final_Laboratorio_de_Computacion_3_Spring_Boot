package com.utn.proyectofinal.controller;


import com.utn.proyectofinal.business.MateriaService;
import com.utn.proyectofinal.business.ProfesorService;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.dto.MateriaDto;
import com.utn.proyectofinal.persistence.exeptions.Error_Materia_No_Encontrada;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("materia")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;
    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Materia> getMaterias() {
        return materiaService.todasLasMaterias();
    }

    @PostMapping
    public ResponseEntity<MateriaDto> crearMateria(@RequestBody MateriaDto materiaDto) throws Error_Profesor_No_Encontrado, Error_Materia_No_Encontrada {
        Materia m = materiaService.crearMateria(materiaDto);
        materiaDto.setNombre(profesorService.buscarProfesorPorId(materiaDto.getProfesorId()).getNombre());
        if (m!=null){
            return ResponseEntity.ok(materiaDto);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{idMateria}")
    public Materia getMateriaById(@PathVariable Integer idMateria) throws Error_Materia_No_Encontrada {
        return materiaService.getMateriaById(idMateria);
    }
}