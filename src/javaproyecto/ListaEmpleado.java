/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luban
 */
public class ListaEmpleado {

    public static void listaDeEmpleado() throws SQLException, IOException {
        String query = "select * from empleados";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            
            FileWriter fstream = new FileWriter("manpreet.txt");
            BufferedWriter out = new BufferedWriter(fstream);
            
            System.out.println("Completed writing into text file...");
        }
    }
}