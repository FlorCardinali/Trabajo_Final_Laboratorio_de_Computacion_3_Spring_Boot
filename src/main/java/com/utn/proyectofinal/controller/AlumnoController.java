package com.utn.proyectofinal.controller;

import com.utn.proyectofinal.business.AlumnoService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/crear")
    public Alumno crearAlumno(@RequestBody AlumnoDto alumnoDto) {

        return alumnoService.crearAlumno(alumnoDto);

    }
    @GetMapping
    public Alumno buscarAlumno(@RequestParam String apellido) {

        return alumnoService.buscarAlumnoPorApellido(apellido);

    }
}
