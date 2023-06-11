/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Miembro;
import Modelo.Proyecto;
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
public class DataProyecto {

    private Connection con = null;

    public DataProyecto() {
        con = Conexion.getConnection();
    }

    public void guardarProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO proyecto (nombre, descripcion, fechaInicio, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getDescripcion());
            ps.setDate(3, Date.valueOf(proyecto.getFechaInicio()));
            ps.setInt(4, proyecto.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                JOptionPane.showMessageDialog(null, "Proyecto añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }

    }

    public List<Proyecto> consultarProyectos() {

        List<Proyecto> proyectos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM proyecto WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proyecto proyecto = new Proyecto();

                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setDescripcion(rs.getString("descripcion"));
                proyecto.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                proyecto.setEstado(rs.getInt("estado"));
                proyecto.setIdProyecto(rs.getInt("idProyecto"));
                proyectos.add(proyecto);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }
        return proyectos;
    }

    public Proyecto buscarProyecto(int id) {
        Proyecto proyecto = new Proyecto();
        String sql = "SELECT * FROM proyecto WHERE idProyecto = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setDescripcion(rs.getString("direccion"));
                proyecto.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
                proyecto.setEstado(rs.getInt("estado"));
                proyecto.setIdProyecto(rs.getInt("idProyecto"));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el proyecto.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proyecto" + ex.getMessage());
        }
        return proyecto;
    }

    public void eliminarProyecto(int id) {

        try {
            String sql = "UPDATE proyecto SET estado = 0 WHERE idProyecto = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();

            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se eliminó el proyecto.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Proyecto");
        }
    }

    public void activarProyecto(int id) {

        try {
            String sql = "UPDATE proyecto SET estado = 1 WHERE idProyecto = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int fila = ps.executeUpdate();
            ps.close();
            if (fila == 1) {
                JOptionPane.showMessageDialog(null, " Se activo el proyecto.");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Proyecto");
        }
    }

}
