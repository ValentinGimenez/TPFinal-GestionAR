/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;

/**
 *
 * @author Valentin
 */
public class Tarea {

    private int idTarea;
    private EquipoMiembros equipomiembros;
    private String nombre;
    private LocalDate fechaCreacion;
    private LocalDate fechaCierre;
    private int estado;

    public Tarea() {

    }

    public Tarea(int idTarea, EquipoMiembros equipomiembros, String nombre, LocalDate fechaCreacion, LocalDate fechaCierre, int estado) {
        this.idTarea = idTarea;
        this.equipomiembros = equipomiembros;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }

    public Tarea(EquipoMiembros equipomiembros, String nombre, LocalDate fechaCreacion, LocalDate fechaCierre, int estado) {
        this.equipomiembros = equipomiembros;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaCierre = fechaCierre;
        this.estado = estado;
    }
    

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public EquipoMiembros getEquipomiembros() {
        return equipomiembros;
    }

    public void setEquipomiembros(EquipoMiembros equipomiembros) {
        this.equipomiembros = equipomiembros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Tarea{" + "idTarea=" + idTarea + ", equipomiembros=" + equipomiembros + ", nombre=" + nombre + ", fechaCreacion=" + fechaCreacion + ", fechaCierre=" + fechaCierre + ", estado=" + estado + '}';
    }

}
