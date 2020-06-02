/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package javaproyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luban
 *//*
public class generarNomina extends Empleado {

    public void generaNomina() throws SQLException, IOException {

        String query = "select empId,nombre,apellido1,apellido2,correo,movil from empleado";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);

        ResultSet rs = ps.executeQuery();
        FileWriter fstream = new FileWriter("file.txt");
        try (BufferedWriter out = new BufferedWriter(fstream)) {
            while (rs.next()) {
                
                out.write(Integer.toString(rs.getInt("id")) + ", ");
                out.write(rs.getString("nombre") + ", ");
                out.write(rs.getString("apellido1") + ", ");
                out.write(rs.getString("apellido2") + ", ");
                out.write(rs.getString("correo") + ", ");
                out.write(Integer.toString(rs.getInt("movil")) + ", ");
                out.newLine();
                
            }
            System.out.println("hecho escribir dato en archivo");
        }catch(Exception e){
            e.getMessage();
        }
        
        
    }
    
}*//*
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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author luban
 */
public class generarNomina extends Empleado {

    Empleado emp = new Empleado();

    /*public void generaNomina() throws SQLException, IOException {

        try {
            String query = "select empId,nombre from empleado";
            PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            int numberOfColumns = rsmd.getColumnCount();

            for (int i = 1; i <= numberOfColumns; i++) {
                if (i > 1) {
                    System.out.print(",  ");
                }
                String columnName = rsmd.getColumnName(i);
                System.out.print(columnName);
            }

            FileWriter fstream = new FileWriter("file.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            while (rs.next()) {*/

                /*out.write(Integer.toString(rs.getInt("empId")) + ", ");
            out.write(Integer.toString(rs.getInt("depID")) + ", ");
            out.write(rs.getString("nombre") + ", ");
            out.write(rs.getString("apellido1") + ", ");
            out.write(rs.getString("apellido2") + ", ");
            out.write(rs.getString("correo") + ", ");
            out.write(Integer.toString(rs.getInt("movil")) + ", ");
            out.newLine();
            
            System.out.println("hecho escribir dato en archivo");
            out.close();*/
               /* try {
                    int empId = rs.getInt("empId");
                    String nombre = rs.getString("nombre");

                    out.write(empId);
                    out.write(nombre);
                    out.newLine();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            }
            out.close();
            ps.close();
        } catch (IOException | SQLException e1) {
            e1.getMessage();
        }
    }*/
    
    public void generaNomina() throws SQLException {
        String query = "select * from empleado";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);
        
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            System.out.println("ya tienes ");
        }else{
            System.out.println("tiene erro");
        }
    }
}

