/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author RicardoM
 */
public class Db {
    
     public Connection conexion() {
        String url = "jdbc:mysql://localhost/concesionario";
        String usuario = "root";
        String password = "";
        Connection conexion = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            System.out.println("ERROR DE CONEXION" + e.getMessage());
        }
        return conexion;
    }
    
}
