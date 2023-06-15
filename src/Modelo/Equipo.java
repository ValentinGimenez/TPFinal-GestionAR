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
public class Equipo {

    private Proyecto proyecto;
    private int idEquipo;
    private String nombre;
    private LocalDate fechaCreacion;
    private int estado;

    public Equipo() {

    }

    public Equipo(Proyecto proyecto, int idEquipo, String nombre, LocalDate fechaCreacion, int estado) {
        this.proyecto = proyecto;
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Equipo(Proyecto proyecto, String nombre, LocalDate fechaCreacion, int estado) {
        this.proyecto = proyecto;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proyecto: " + proyecto + " - Equipo: " + nombre;
    }

}
