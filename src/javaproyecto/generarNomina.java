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
import java.util.Scanner;

/**
 *
 * @author luban
 */
public class generarNomina {

    static Scanner lector = new Scanner(System.in);

    public void generaNomina() throws SQLException, IOException {

        Empleado emp1 = new Empleado();
        SalarioEmpleado salarioEmp = new SalarioEmpleado();
        
        String query = "select * from empleado where id =?";
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);
        pst.setInt(1, emp1.getId());
        ResultSet rst = pst.executeQuery();
        rst.next();
        rst.close();
        
        String q = "select * from salario where id =?";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(q);
        rst = pst.executeQuery();

        while (rst.next()) {
            FileWriter fstream = new FileWriter("manpreet2.txt");
            BufferedWriter br = new BufferedWriter(fstream);
            br.write("id");
            emp1.setId(lector.nextInt());

            br.write("nombre");
            emp1.setNombre(lector.next());

            br.write("Salario Basico");
            salarioEmp.getSalarioBasico();

            br.write("irpf");
            salarioEmp.getIrpf();

            br.write("Base de cotitzacion");
            salarioEmp.getBaseDeCotitzacio();

            br.write("Salario Net");
            salarioEmp.calculaSalario();
        }
    }

}
