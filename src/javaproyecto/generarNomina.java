/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luban
 */
public class generarNomina extends Empleado {

    Empleado emp = new Empleado();

    /**
     * metodo para generar nomina
     *
     * @throws SQLException
     */
    public void generaNomina() throws SQLException {

        try {
            String q = "select empId,salarioBase,irpf,baseDeCotitzacion,salarioNeto from salario";
            PreparedStatement psmnt = conecion_bbdd.establecerConexion().prepareStatement(q);
            ResultSet rs = psmnt.executeQuery();

            while (rs.next()) {
                System.out.println("empID : " + rs.getInt(1));
                System.out.println("salarioBase : " + rs.getString(2));
                System.out.println("irpf : " + rs.getString(3));
                System.out.println("baseDeCotitzacion : " + rs.getString(4));
                System.out.println("salarioNeto : " + rs.getString(5));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo para crear archivos
     */
    public void creaArchivo() {
        try {
            String content = "todo esto es el proyecto final";

            File file = new File("filename.txt");

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

            System.out.println("Ya esta");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
