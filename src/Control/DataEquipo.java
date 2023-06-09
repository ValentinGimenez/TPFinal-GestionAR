/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.Equipo;
import Modelo.Miembro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
