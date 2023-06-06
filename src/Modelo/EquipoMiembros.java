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
    private int idEquipo;
    private int idMiembro;
    private LocalDate fechaIncorporacion;

    public EquipoMiembros() {

    }

    public EquipoMiembros(int idMiembroEq, int idEquipo, int idMiembro, LocalDate fechaIncorporacion) {
        this.idMiembroEq = idMiembroEq;
        this.idEquipo = idEquipo;
        this.idMiembro = idMiembro;
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public int getIdMiembroEq() {
        return idMiembroEq;
    }

    public void setIdMiembroEq(int idMiembroEq) {
        this.idMiembroEq = idMiembroEq;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdMiembro() {
        return idMiembro;
    }

    public void setIdMiembro(int idMiembro) {
        this.idMiembro = idMiembro;
    }

    public LocalDate getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(LocalDate fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    @Override
    public String toString() {
        return "EquipoMiembros{" + "idMiembroEq=" + idMiembroEq + ", idEquipo=" + idEquipo + ", idMiembro=" + idMiembro + ", fechaIncorporacion=" + fechaIncorporacion + '}';
    }

}
