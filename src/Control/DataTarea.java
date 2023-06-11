/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Proyecto;
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
public class DataTarea {

    private Connection con = null;
    private DataMiembro dataMiembro = new DataMiembro();

    public DataTarea() {
        con = Conexion.getConnection();
    }

    public void guardarTarea(Tarea tarea) {
        String sql = "INSERT INTO tarea (nombre, fechaCreacion, fechaCierre, estado, idMiembroEq) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tarea.getNombre());
            ps.setDate(2, Date.valueOf(tarea.getFechaCreacion()));
            ps.setDate(3, Date.valueOf(tarea.getFechaCierre()));
            ps.setInt(4, tarea.getEstado());
            ps.setInt(5, tarea.getEquipomiembros().getIdMiembroEq());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                tarea.setIdTarea(rs.getInt("idTarea"));
                JOptionPane.showMessageDialog(null, "Tarea añadida con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }

    }

    public List<Tarea> consultarTareas() {

        List<Tarea> tareas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tarea WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tarea tarea = new Tarea();

                tarea.setNombre(rs.getString("nombre"));
                tarea.setFechaCreacion(rs.getDate("fechaInicio").toLocalDate());
                tarea.setFechaCierre(rs.getDate("fechaCierre").toLocalDate());
                tarea.setEstado(rs.getInt("estado"));
                int idMiembro = rs.getInt("idMiembro");

                tareas.add(tarea);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }
        return tareas;
    }

    public void actualizarEstadoTarea(int idTarea, int newEstado) {

        String sql = "UPDATE tarea SET estado = ? WHERE  idTarea = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, newEstado);
            ps.setInt(2, idTarea);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Se modifico correctamente el estado.");
            } else {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Tarea" + ex.getMessage());
        }

    }

}
