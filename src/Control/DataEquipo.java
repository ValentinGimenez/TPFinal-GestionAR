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
    
    public void guardarEquipo(Equipo equipo){
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
                JOptionPane.showMessageDialog(null, "Proyecto añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Equipo" + ex.getMessage());
        }

    }
    
    public Equipo buscarEquipo(int id){
        Equipo equipo = new Equipo();
        String sql = "SELECT * FROM equipo WHERE idEquipo = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                equipo.setProyecto(dataProyecto.buscarProyecto(rs.getInt("dni")));
                equipo.setFechaCreacion(rs.getDate("fechaCreacion").toLocalDate());
                equipo.setNombre(rs.getString("nombre"));
                equipo.setEstado(rs.getInt("estado"));
                
                
            }else{
                //en vistas, cartelito que diga "no se pudo buscar el producto" o "no existe el producto"
            }
            ps.close();
            
        }catch(SQLException ex){
            //cartelito "error en buscar producto"
        }
        return equipo ;
    }
}
