/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 *
 * @author luban
 */
public class ListaEmpleado {

    /**
     * EL metodo es para mostrar lista de los empleados de sistema.
     * @throws SQLException este excepcion es para query de sql
     * @throws IOException esto excepcion es interrumpted exception
     */
    public static void listaDeEmpleado() throws SQLException, IOException {
        
        ArrayList <Empleado> listaEmp = new ArrayList <Empleado>();
        listaEmp.listIterator();
        
        String query = "select * from empleado";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Empleado emp = new Empleado();
            emp.setNombre(rs.getString("nombre"));
            emp.setApellido1(rs.getString("apellido1"));
            emp.setApellido2(rs.getString("apellido2"));
            emp.setCorreo(rs.getString("correo"));
            emp.setBaseDeCotitzacion(rs.getFloat("baseDeCotitzacion"));
            emp.setDireccion(rs.getString("direccion"));
            emp.setFechaDeNacimiento(rs.getString("fechaDeNacimiento"));
            emp.setGenero(rs.getString("genero"));
            emp.setIrpf(rs.getFloat("irpf"));
            emp.setMovil(rs.getInt("movil"));
            emp.setNif(rs.getString("nif"));
            emp.setProvincia(rs.getString("provincia"));
            emp.setSalarioBasico(rs.getFloat("salarioBasico"));
            listaEmp.add(emp);
            System.out.println("Completed writing into text file...");
            
          
        }
    }
    public static void archivoDeEmpleado(java.util.List lista,String path) throws IOException{
        
            FileWriter fstream = new FileWriter("manpreet.txt");
            BufferedWriter br = new BufferedWriter(fstream);
            
            
        
    }
}