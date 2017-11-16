/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Carros;

/**
 *
 * @author RicardoM
 */
public class CarrosDao {
    Db con;
    Connection cn;
    PreparedStatement st;
    
    public CarrosDao() {
        con = new Db();
    }
    
    public List<Carros> cargarCarros() {
        List<Carros> carros = new ArrayList<>();
        ResultSet rs = null;
        try {
            cn = con.conexion();
            String query = "SELECT * FROM carros";
            st = cn.prepareCall(query);
            rs = st.executeQuery();
            while (rs.next()) {
                Carros carro = new Carros();
                carro.setId(rs.getInt("id"));
                carro.setMarca(rs.getString("marca"));
                carro.setModelo(rs.getString("modelo"));
                carro.setPrecio(rs.getFloat("precio"));

                carros.add(carro);
            }
            if (!cn.isClosed()) {
                cn.close();
            }
            st.close();
            rs.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return carros;
    }
    

    public boolean addCar(Carros carros) {
        boolean registro = false;
        try {
            cn = con.conexion();
            String query = "INSERT INTO carros(\n"
                    + "	marca, modelo, precio)\n"
                    + "	VALUES ( ?, ?, ?)";
            st = cn.prepareCall(query);
           
            st.setString(1, carros.getMarca());
            st.setString(2, carros.getModelo());
            st.setFloat(3, carros.getPrecio());

            st.execute();

            registro = true;
            if (!cn.isClosed()) {
                cn.close();
            }
            st.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }

    public boolean resetList() {
        boolean registro = false;
        try {
            cn = con.conexion();
            String query = "DELETE FROM carros\n";
            st = cn.prepareCall(query);

            st.execute();

            registro = true;
            if (!cn.isClosed()) {
                cn.close();
            }
            st.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }

    public boolean deleteCar(Carros carros) {
        boolean registro = false;
        try {
            cn = con.conexion();
                String query = "DELETE FROM carros WHERE id = ?";
                st= cn.prepareCall(query);
                st.setInt(1, carros.getId());
                st.execute();
                registro = true;
            
            if (!cn.isClosed()) {
                cn.close();
            }
            st.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }

    public boolean editCar(Carros carros) {
        boolean registro = false;
        try {
            cn = con.conexion();
            
                String query = "UPDATE carros SET marca=?, modelo=?, precio=? WHERE id = ?";
                st= cn.prepareCall(query);
                st.setString(1, carros.getMarca());
                st.setString(2, carros.getModelo());
                st.setFloat(3, carros.getPrecio());
                st.setInt(4, carros.getId());
                st.execute();
                //  connection.commit();
                registro = true;
            
            if (!cn.isClosed()) {
                cn.close();
            }
            st.close();

        } catch (SQLException ex) {
            System.out.print(ex.toString());
        }

        return registro;
    }
    
    
    
}
