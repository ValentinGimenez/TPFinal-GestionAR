/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Proyecto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    
    public void guardarProyecto(Proyecto proyecto){
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
    
    
}
