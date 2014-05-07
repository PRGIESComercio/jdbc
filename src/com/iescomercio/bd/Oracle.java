/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iescomercio.bd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ProfVespertino
 */
public class Oracle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Carga de forma dinámica el driver de Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // Establece la conexión
            Connection con = DriverManager.getConnection(
                    //"jdbc:oracle:thin:@localhost:1521:XE [system on LIBRO]",
                    "jdbc:oracle:thin:@localhost:1521:XE",
                    "system",
                    "edu1");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from LIBRO.ALUM");

            while (rs.next()) {
                String x = rs.getString("NOMBRE");
                int s = rs.getInt("EDAD");
                String x2 = rs.getString("LOCALIDAD");
                System.out.println("Nombre: " + x + " Edad: " + s + " Localidad: " + x2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Oracle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Oracle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
