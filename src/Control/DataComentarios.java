/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Comentarios;
import Modelo.Tarea;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Valentin
 */
public class DataComentarios {

    private Connection con = null;
    private DataTarea datatarea = new DataTarea();

    public DataComentarios() {
        con = Conexion.getConnection();
    }

    public void guardarComentario(Comentarios comentarios) {
        String sql = "INSERT INTO comentarios (comentario, fechaAvance, idTarea) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comentarios.getComentario());
            ps.setDate(2, Date.valueOf(comentarios.getFechaAvance()));
            ps.setInt(3, comentarios.getTarea().getIdTarea());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comentarios.setIdComentario(rs.getInt("idComentario"));
                JOptionPane.showMessageDialog(null, "Comentario añadida con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comentarios" + ex.getMessage());
        }

    }

    public List<Comentarios> listarComentariosPorTarea(int idTarea) {
        List<Comentarios> comentarios = new ArrayList<>();
        try {
            String sql = "SELECT * FROM comentarios WHERE idTarea = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTarea);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comentarios comentario = new Comentarios();
                comentario.setComentario(rs.getString("comentario"));
                comentario.setFechaAvance(rs.getDate("fechaAvance").toLocalDate());
                comentario.setTarea(datatarea.buscarTarea(rs.getInt("idTarea")));
                comentario.setIdComentario(rs.getInt("idComentario"));
                comentarios.add(comentario);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea: " + ex.getMessage());
        }
        return comentarios;
    }
    public void modificarComentario(Comentarios comentarios) {
        String sql = "UPDATE comentarios SET comentario = ?, fechaAvance = ?, idTarea = ? WHERE idComentario = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comentarios.getComentario());
            ps.setDate(2, Date.valueOf(comentarios.getFechaAvance()));
            ps.setInt(3, comentarios.getTarea().getIdTarea());
            ps.setInt(4, comentarios.getIdComentario());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Comentario añadida con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comentarios" + ex.getMessage());
        }

    }
}
