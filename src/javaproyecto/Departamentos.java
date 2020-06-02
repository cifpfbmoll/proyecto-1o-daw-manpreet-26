/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author luban
 */
public class Departamentos {
    private int id;
    private String nombreDepartamento;
    
    Scanner lector = new Scanner(System.in);

    public Departamentos() {
    }

    public Departamentos(int id, String nombreDepartamento) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    
    public void agregarDepartamento() throws SQLException{
        System.out.println("El id del departamento es : ");
        this.setId(lector.nextInt());
        System.out.println("El nombre del departamento es : ");
        this.setNombreDepartamento(lector.next());
        
        String query = "insert into departamento (depId,depNombre) values (?,?)";
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);
        
        pst.setInt(1, id);
        pst.setString(2, nombreDepartamento);
        pst.executeUpdate();
        
    }
    
  
}
