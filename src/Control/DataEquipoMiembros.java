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
    
    public void guardarEquipoMiembros(EquipoMiembros equipoMiembros){
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
                JOptionPane.showMessageDialog(null, "EquipoMiembro añadido con exito.");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla EquipoMiembro" + ex.getMessage());
        }

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
                miembros.add(miembro);
            }
            ps.close();

        } catch (SQLException ex) {
            // mensajito de error en vista
        }
        return miembros;
    }
}
