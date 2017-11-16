/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author RicardoM
 */
public class Conectiondb {
    
     Connection cn;
    Statement st;
    
    public Connection conexion(){
      try{ 
        Class.forName("com.mysql.jdbc.Driver");
        cn = DriverManager.getConnection("jdbc:mysql://localhost/concesionario","root","");
        System.out.println("Se hizo la conexion exitosa");
      }catch(Exception e){
          System.out.println(e.getMessage());
      }return cn;
    }    
    
    Statement createStatement(){
        throw new UnsupportedOperationException("No soportado");
    }
    
}
