package com.utn.proyectofinal.controller;

import com.utn.proyectofinal.business.ProfesorService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.Profesor;
import com.utn.proyectofinal.model.dto.ProfesorDto;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @PostMapping
    public Profesor crearProfesor(@RequestBody ProfesorDto profesorDto){
        return profesorService.crearProfesor(profesorDto);
    }
    @PutMapping("/{id}")
    public Profesor actualizarProfesor(@PathVariable long id, @RequestBody ProfesorDto profesorDto) throws Error_Profesor_No_Encontrado {
        Profesor p = profesorService.buscarProfesorPorId(id);
        return profesorService.actualizarProfesor(p,profesorDto);
    }

    @GetMapping("materias")
    public List<Materia> materiasProfesor(@PathVariable long id){
        return profesorService.materiasProfesor(id);
    }


}
