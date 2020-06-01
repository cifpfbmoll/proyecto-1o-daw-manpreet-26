/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author luban
 */
public class generarNomina {

    /**
     * tenemos scanner para introducer el tipo de static
     */
    static Scanner lector = new Scanner(System.in);

    /**
     * metodo para generar nomina del empleado
     * @throws SQLException excepcion dele tipo sql
     * @throws IOException excepcion 
     */
    public void generaNomina() throws SQLException, IOException {

        Empleado emp1 = new Empleado();
       
        String q = "select * from empleado where id =?";
        
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(q);
        ps.setInt(1, emp1.getId());
        ResultSet rst = ps.executeQuery();
        
        while (rst.next()) {
            FileWriter fstream = new FileWriter("manpreet2.txt");
            BufferedWriter br = new BufferedWriter(fstream);
            br.write("id");
            emp1.setId(lector.nextInt());

            br.write("nombre");
            emp1.setNombre(lector.next());

            br.write("Salario Basico");
            emp1.getSalarioBasico();

            br.write("irpf");
            emp1.getIrpf();

            br.write("Base de cotitzacion");
            emp1.getBaseDeCotitzacion();

            br.write("Salario Net");
            emp1.calculaSalario();
        }
        
        String query = "update from empleado where id =?";
        
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);
        String sql = "select id from empleado";
        PreparedStatement ps2 = conecion_bbdd.establecerConexion().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1, emp1.getId());
        pst.executeUpdate();
        
        
    }

}
