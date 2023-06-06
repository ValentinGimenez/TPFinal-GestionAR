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
public class Comentarios {

    private int idComentario;
    private Tarea Tarea;
    private String comentario;
    private LocalDate fechaAvance;

    public Comentarios() {

    }

    public Comentarios(int idComentario, Tarea Tarea, String comentario, LocalDate fechaAvance) {
        this.idComentario = idComentario;
        this.Tarea = Tarea;
        this.comentario = comentario;
        this.fechaAvance = fechaAvance;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public Tarea getTarea() {
        return Tarea;
    }

    public void setTarea(Tarea Tarea) {
        this.Tarea = Tarea;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getFechaAvance() {
        return fechaAvance;
    }

    public void setFechaAvance(LocalDate fechaAvance) {
        this.fechaAvance = fechaAvance;
    }

    @Override
    public String toString() {
        return "Comentarios{" + "idComentario=" + idComentario + ", Tarea=" + Tarea + ", comentario=" + comentario + ", fechaAvance=" + fechaAvance + '}';
    }

}
