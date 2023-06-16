/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Equipo;
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
public class DataEquipo {

    private Connection con = null;
    private DataProyecto dataProyecto = new DataProyecto();

    public DataEquipo() {
        con = Conexion.getConnection();
    }

    public void guardarEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipo (idProyecto, nombre, fechaCreacion, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setInt(4, equipo.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipo.setIdEquipo(rs.getInt("idEquipo"));
                JOptionPane.showMessageDialog(null, "Equipo añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }

    }

    public Equipo buscarEquipo(int id) {
        Equipo equipo = new Equipo();
        String sql = "SELECT * FROM equipo WHERE idEquipo = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                equipo.setProyecto(dataProyecto.buscarProyecto(rs.getInt("idProyecto")));
                equipo.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                equipo.setNombre(rs.getString("nombre"));
                equipo.setEstado(rs.getInt("estado"));
                equipo.setIdEquipo(rs.getInt("idEquipo"));

            } else {
                JOptionPane.showMessageDialog(null, "No se encontro Equipo con el id solicitado.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
        return equipo;
    }

    public List<Equipo> listarEquipos() {

        List<Equipo> equipos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM equipo WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombre(rs.getString("nombre"));
                equipo.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                equipo.setEstado(rs.getInt("estado"));
                equipo.setIdEquipo(rs.getInt("idEquipo"));
                equipo.setProyecto(dataProyecto.buscarProyecto(rs.getInt("idProyecto")));
                equipos.add(equipo);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
        return equipos;
    }

    public List<Equipo> listarEquiposPorProyecto(int idProyecto) {

        List<Equipo> equipos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM equipo WHERE idProyecto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Equipo equipo = new Equipo();
                equipo.setNombre(rs.getString("nombre"));
                equipo.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                equipo.setEstado(rs.getInt("estado"));
                equipo.setIdEquipo(rs.getInt("idEquipo"));
                equipo.setProyecto(dataProyecto.buscarProyecto(rs.getInt("idProyecto")));
                equipos.add(equipo);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }
        return equipos;
    }
    public void modificarEquipo(Equipo equipo) {
        String sql = "UPDATE equipo SET idProyecto = ?, nombre = ?, fechaCreacion = ?, estado = ? WHERE idEquipo = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, equipo.getProyecto().getIdProyecto());
            ps.setString(2, equipo.getNombre());
            ps.setDate(3, Date.valueOf(equipo.getFechaCreacion()));
            ps.setInt(4, equipo.getEstado());
            ps.setInt(5, equipo.getIdEquipo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Equipo añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }

    }
}
