/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.EquipoMiembros;
import Modelo.Miembro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public EquipoMiembros buscarEquipoMiembros(int id){
        EquipoMiembros equipoMiembros = new EquipoMiembros();
        String sql = "SELECT * FROM equipoMiembros WHERE idEquipoMiembros = ?";
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                equipoMiembros.setFechaIncorporacion(rs.getDate("fechaIncorporacion").toLocalDate());
                equipoMiembros.setMiembro(dataMiembro.buscarMiembro(rs.getInt("miembro")));
                equipoMiembros.setEquipo(dataEquipo.buscarEquipo(rs.getInt("equipo")));
            }else{
                //en vistas, cartelito que diga "no se pudo buscar el producto" o "no existe el producto"
            }
            ps.close();
            
        }catch(SQLException ex){
            //cartelito "error en buscar producto"
        }
        return equipoMiembros ;
    }
    
}
