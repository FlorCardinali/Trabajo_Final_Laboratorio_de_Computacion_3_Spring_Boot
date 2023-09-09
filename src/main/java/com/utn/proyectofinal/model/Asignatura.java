package com.utn.proyectofinal.model;
import com.utn.proyectofinal.model.exeptions.Error_Estado_Incorrecto;
import com.utn.proyectofinal.model.exeptions.Error_Nota_Insuficiente;

import java.util.Optional;
public class Asignatura {
    private long idAsigantura;
    private Materia materia;
    private EstadoAsignatura estado;
    private int nota= -1;

    //constructores

    public Asignatura() {
    }

    //getters
    public int getNota() {
        //-1 no seteado.
        return nota;
    }
    public Materia getMateria() {
        return materia;
    }
    public EstadoAsignatura getEstado() {
        return estado;
    }

    public long getIdAsigantura() {
        return idAsigantura;
    }

    //setters
    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    public void setEstado(EstadoAsignatura e){
        this.estado = e;
    }

    public Asignatura cursarAsignatura() throws Error_Estado_Incorrecto {
        if (this.estado==EstadoAsignatura.CURSADA){
            throw new Error_Estado_Incorrecto("Se intento cursar una materia que ya esta cursada.");
        } else if (this.estado == EstadoAsignatura.APROBADA){
            throw new Error_Estado_Incorrecto("Se intento cursar una amteria que ya esta aprobada");
        } else {
            this.estado= EstadoAsignatura.CURSADA;
            return this;
        }
    }
    public Asignatura aprobarAsignatura(int nota) throws Error_Estado_Incorrecto, Error_Nota_Insuficiente {
        if (!this.estado.equals(EstadoAsignatura.CURSADA)) {
            throw new Error_Estado_Incorrecto("La materia " + this.materia.getNombre() + " debe estar cursada antes de ser aprobada.");
        }
        if (nota>=4) {
            this.estado = EstadoAsignatura.APROBADA;
            this.nota = nota;
            return this;
        }else {
            throw new Error_Nota_Insuficiente("La nota debe ser cuatro o superior para aprobar la materia " + this.materia.getNombre());
        }
    }
    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setIdAsigantura(long idAsigantura) {
        this.idAsigantura = idAsigantura;
    }
}
