package com.utn.proyectofinal.controller;

import com.utn.proyectofinal.business.AlumnoService;
import com.utn.proyectofinal.business.AsignaturaService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Asignatura;
import com.utn.proyectofinal.model.EstadoAsignatura;
import com.utn.proyectofinal.model.dto.AlumnoDto;
import com.utn.proyectofinal.model.exeptions.Error_Asignatura_No_encontrada;
import com.utn.proyectofinal.model.exeptions.Error_Correlatividad_No_Aprobada;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;
import com.utn.proyectofinal.persistence.exeptions.Error_Alumno_No_Encontrado;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
@RequestMapping("alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @PostMapping
    public ResponseEntity<Alumno> crearAlumno(@RequestBody AlumnoDto alumnoDto) {
        Alumno alumno = alumnoService.crearAlumno(alumnoDto);
        if (alumno != null) {
            return ResponseEntity.ok(alumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/agregarAsignatura/{idAlumno}")
    public Asignatura agregarAsignatura(@PathVariable long idAlumno,@RequestBody Asignatura a) throws Error_Estado_Incorrecto, Error_Alumno_No_Encontrado {
        return alumnoService.agregarAsignatura(a,idAlumno);
    }

    @PutMapping("/{id}")
    public Alumno modificarAlumno(@PathVariable long id, @RequestBody AlumnoDto alumnoDto) throws Error_Alumno_No_Encontrado {
        return alumnoService.actualizarAlumno(alumnoDto,id);
    }
    @PutMapping("/{idAlumno}/asignatura/{idAsignatura}")
    public Asignatura modificarAsignatura(@PathVariable long idAlumno, long idAsignatura, @RequestBody Asignatura asignatura) throws Error_Asignatura_No_encontrada, Error_Estado_Incorrecto, Error_Correlatividad_No_Aprobada, Error_Alumno_No_Encontrado, Error_Nota_Insuficiente {
        return alumnoService.modificarAsignatura(asignatura,idAsignatura,idAlumno);
    }
    @GetMapping
    public ResponseEntity<Alumno> buscarAlumno(@RequestParam String apellido) throws Error_Alumno_No_Encontrado {
        Alumno alumno = alumnoService.buscarAlumnoPorApellido(apellido);
        if (alumno != null) {
            return ResponseEntity.ok(alumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<AlumnoDto> eliminarAlumno(@PathVariable long id) throws Error_Alumno_No_Encontrado {
        Alumno a = alumnoService.eliminarAlumno(id);
        AlumnoDto dto = new AlumnoDto();
        dto.setNombre(a.getNombre());
        dto.setApellido(a.getApellido());
        dto.setDni(a.getDni());
        if (a!=null){
            return ResponseEntity.ok(dto);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
