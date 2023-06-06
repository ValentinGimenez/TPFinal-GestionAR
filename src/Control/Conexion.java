/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Valentin
 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost/";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_NAME = "gestionar";

    private static Connection connection;

    private Conexion() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL + DATABASE_NAME, USER, PASSWORD);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos :'" + DATABASE_NAME + "'" + ex.getMessage());
            }
        }
        return connection;
    }
}
