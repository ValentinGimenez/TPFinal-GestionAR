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
public class EquipoMiembros {

    private int idMiembroEq;
    private Equipo equipo;
    private Miembro miembro;
    private LocalDate fechaIncorporacion;

    public EquipoMiembros() {

    }

    public EquipoMiembros(int idMiembroEq, Equipo equipo, Miembro miembro, LocalDate fechaIncorporacion) {
        this.idMiembroEq = idMiembroEq;
        this.equipo = equipo;
        this.miembro = miembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public int getIdMiembroEq() {
        return idMiembroEq;
    }

    public void setIdMiembroEq(int idMiembroEq) {
        this.idMiembroEq = idMiembroEq;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return "EquipoMiembros{" + "idMiembroEq=" + idMiembroEq + ", equipo=" + equipo + ", miembro=" + miembro + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }

}
