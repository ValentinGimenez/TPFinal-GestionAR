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
public class DataMiembro {

    private Connection con = null;

    public DataMiembro() {
        con = Conexion.getConnection();
    }
    
    public List<Miembro> consultarMiembros() {

        List<Miembro> miembros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM miembro WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Miembro miembro = new Miembro();
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setEstado(rs.getInt("estado"));
                miembro.setDni(rs.getInt("dni"));
                miembros.add(miembro);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }
        return miembros;
    }

    public void guardarMiembro(Miembro miembro) {
        String sql = "INSERT INTO miembro (dni, apellido, nombre, estado) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setInt(4, miembro.getEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                JOptionPane.showMessageDialog(null, "Miembro añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }

    }

    public Miembro buscarMiembro(int id) {
        Miembro miembro = new Miembro();
        String sql = "SELECT * FROM miembro WHERE idMiembro = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miembro.setDni(rs.getInt("dni"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setEstado(rs.getInt("estado"));
                miembro.setIdMiembro(rs.getInt("idMiembro"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro un miembro con el id solicitado.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }
        return miembro;
    }

    public Miembro buscarMiembroPorDNI(int dni) {
        Miembro miembro = new Miembro();
        String sql = "SELECT * FROM miembro WHERE dni = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                miembro.setDni(rs.getInt("dni"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setEstado(rs.getInt("estado"));
                ps.close();
                return miembro;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro un miembro con el dni solicitado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }
        return null;
    }
    public void modificarMiembro(Miembro miembro) {
        String sql = "UPDATE miembro SET dni = ?, apellido = ?, nombre = ?, estado = ? WHERE idMiembro = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, miembro.getDni());
            ps.setString(2, miembro.getApellido());
            ps.setString(3, miembro.getNombre());
            ps.setInt(4, miembro.getEstado());
            ps.setInt(5, miembro.getIdMiembro());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Miembro añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Miembro" + ex.getMessage());
        }

    }
}
