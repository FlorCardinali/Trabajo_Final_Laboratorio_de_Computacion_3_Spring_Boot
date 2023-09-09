package com.utn.proyectofinal.controller;

import com.utn.proyectofinal.business.MateriaService;
import com.utn.proyectofinal.business.ProfesorService;
import com.utn.proyectofinal.model.Alumno;
import com.utn.proyectofinal.model.Materia;
import com.utn.proyectofinal.model.Profesor;
import com.utn.proyectofinal.model.dto.ProfesorDto;
import com.utn.proyectofinal.persistence.exeptions.Error_Profesor_No_Encontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profesor")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;
    @Autowired
    private MateriaService materiaService;

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody ProfesorDto profesorDto){
        Profesor p = profesorService.crearProfesor(profesorDto);
        if (p!=null){
            return ResponseEntity.ok(p);
        }else {
            return ResponseEntity.internalServerError().build();
        }
    }
    @PutMapping("/{idProfesor}")
    public Profesor actualizarProfesor(@PathVariable long idProfesor, @RequestBody ProfesorDto profesorDto) throws Error_Profesor_No_Encontrado {
        Profesor p = profesorService.buscarProfesorPorId(idProfesor);
        return profesorService.actualizarProfesor(p,profesorDto);
    }


    @GetMapping("/materias")
    public List<Materia> materiasProfesor(@RequestParam long id){
        return materiaService.getMateriasProfesor(id);
    }
    @GetMapping("/apellido")
    public ResponseEntity<Profesor> buscarProfesorPorApellido(@RequestParam String apellido) throws Error_Profesor_No_Encontrado {
        Profesor p = profesorService.buscarProfesorPorApellido(apellido);
        if (p!=null){
            return ResponseEntity.ok(p);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
