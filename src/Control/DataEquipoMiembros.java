/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.EquipoMiembros;
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
public class DataEquipoMiembros {

    private Connection con;
    private DataMiembro dataMiembro = new DataMiembro();
    private DataProyecto dataProyecto = new DataProyecto();
    private DataEquipo dataEquipo = new DataEquipo();

    public DataEquipoMiembros() {
        con = Conexion.getConnection();
    }

    public void guardarEquipoMiembros(EquipoMiembros equipoMiembros) {
        String sql = "INSERT INTO equipoMiembros (fechaIncorporacion, idEquipo, idMiembro) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(equipoMiembros.getFechaIncorporacion()));
            ps.setInt(2, equipoMiembros.getEquipo().getIdEquipo());
            ps.setInt(3, equipoMiembros.getMiembro().getIdMiembro());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                equipoMiembros.setIdMiembroEq(rs.getInt("idMiembroEq"));
                JOptionPane.showMessageDialog(null, "Miembro añadido al equipo con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }

    }

    public EquipoMiembros buscarEquipoMiembros(int id) {
        EquipoMiembros equipoMiembros = new EquipoMiembros();
        String sql = "SELECT * FROM equipoMiembros WHERE idMiembroEq = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                equipoMiembros.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());
                equipoMiembros.setMiembro(dataMiembro.buscarMiembro(rs.getInt("idMiembro")));
                equipoMiembros.setEquipo(dataEquipo.buscarEquipo(rs.getInt("idEquipo")));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro un EquipoMiembro con el id solicitado.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }
        return equipoMiembros;
    }

    public List<Miembro> consultarMiembrosPorIdEquipo(int idEquipo) {

        List<Miembro> miembros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM miembro M JOIN equipomiembros EM ON M.idMiembro = EM.idMiembro WHERE EM.idEquipo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Miembro miembro = new Miembro();
                miembro.setNombre(rs.getString("nombre"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setDni(rs.getInt("dni"));
                miembro.setEstado(rs.getInt("estado"));
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                miembros.add(miembro);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }
        return miembros;
    }

    public boolean consultarMiembroExistente(int idEquipo, int idMiembro) {
        try {
            String sql = "SELECT * FROM miembro M JOIN equipomiembros EM ON M.idMiembro = EM.idMiembro WHERE EM.idEquipo = ? AND EM.idMiembro = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ps.setInt(2, idMiembro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Ya existe el miembro en el equipo.");
                ps.close();
                return true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }
        return false;
    }

    public List<EquipoMiembros> listarEquipoMiembros() {

        List<EquipoMiembros> equipomiembros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM equipomiembros";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EquipoMiembros equipomiembro = new EquipoMiembros();
                equipomiembro.setIdMiembroEq(rs.getInt("idMiembroEq"));
                equipomiembro.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());
                equipomiembro.setEquipo(dataEquipo.buscarEquipo(rs.getInt("idEquipo")));
                equipomiembro.setMiembro(dataMiembro.buscarMiembro(rs.getInt("idMiembro")));
                equipomiembros.add(equipomiembro);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }
        return equipomiembros;
    }

    public List<Miembro> listarMiembrosPorProyecto(int idProyecto) {

        List<Miembro> miembros = new ArrayList<>();
        try {
            String sql = "SELECT M.* FROM miembro M JOIN equipomiembros EM ON M.idMiembro = EM.idMiembro JOIN equipo E ON EM.idEquipo = E.idEquipo WHERE E.idProyecto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idProyecto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Miembro miembro = new Miembro();
                miembro.setNombre(rs.getString("nombre"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setDni(rs.getInt("dni"));
                miembro.setEstado(rs.getInt("estado"));
                miembro.setIdMiembro(rs.getInt("idMiembro"));
                miembros.add(miembro);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }
        return miembros;
    }

    public List<EquipoMiembros> listarEquipoMiembrosPorEquipo(int idEquipo) {

        List<EquipoMiembros> equipomiembros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM equipomiembros WHERE idEquipo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idEquipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                EquipoMiembros equipomiembro = new EquipoMiembros();
                equipomiembro.setIdMiembroEq(rs.getInt("idMiembroEq"));
                equipomiembro.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());
                equipomiembro.setEquipo(dataEquipo.buscarEquipo(rs.getInt("idEquipo")));
                equipomiembro.setMiembro(dataMiembro.buscarMiembro(rs.getInt("idMiembro")));
                equipomiembros.add(equipomiembro);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }
        return equipomiembros;
    }
}
