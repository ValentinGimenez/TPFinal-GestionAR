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
    
    public Miembro buscarMiembro(int id){
        Miembro miembro = new Miembro();
        String sql = "SELECT * FROM miembro WHERE idMiembro = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                miembro.setDni(rs.getInt("dni"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setEstado(rs.getInt("estado"));
                
                
            }else{
                //en vistas, cartelito que diga "no se pudo buscar el producto" o "no existe el producto"
            }
            ps.close();
            
        }catch(SQLException ex){
            //cartelito "error en buscar producto"
        }
        return miembro ;
    }
    
    public void guardarMiembro(Miembro miembro){
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
}
