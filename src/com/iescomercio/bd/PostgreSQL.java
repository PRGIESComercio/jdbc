/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.bd;

import java.sql.*;

/**
 *
 * @author dapelle
 */
public class PostgreSQL {

    public static void main(String[] argv) {
        Connection connection = null;

        try {
            System.out.println("-------- PostgreSQL " + "JDBC Testeando la conexión ------------");
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver Registrado!");

            connection = DriverManager.getConnection("jdbc:postgresql://192.168.15.119:5432/curso1314", "postgres", "curso1314");

            if (connection != null) {
                muestraTabla(connection, "public", "alumnos");

            } else {
                System.out.println("Ha fallado la conexión a la BD!");
            }
        } catch (SQLException e) {
            System.out.println("La conexión ha fallado. Mire el error en la consola ");
            e.printStackTrace();
            return;

        } catch (ClassNotFoundException e) {
            System.out.println("Donde está el Driver JDBC? " + "incluya el path de la libreria!");
            e.printStackTrace();
            return;
        }
    } 
        
        

    public static void muestraTabla(Connection con, String nombreEsquema, String nombreTabla)   throws SQLException {

        Statement stmt = null;
        String query = "select id, nombre, edad from " + nombreEsquema + "." + nombreTabla;

        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
              
                System.out.println(id + "\t" + nombre + "\t" + edad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) 
                stmt.close();
            
        }
    }
}


