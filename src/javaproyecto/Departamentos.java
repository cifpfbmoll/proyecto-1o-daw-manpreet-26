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

    /**
     * constructor sin parametros
     */
    public Departamentos() {
    }

    /**
     * constructor con parametros
     * @param id id de departamento
     * @param nombreDepartamento nombre de departamento
     */
    public Departamentos(int id, String nombreDepartamento) {
        this.id = id;
        this.nombreDepartamento = nombreDepartamento;
    }

    /**
     * getter de id
     * @return id del departamento
     */
    public int getId() {
        return id;
    }

    /**
     * setter de id del departamento
     * @param id id del departamento
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter de nombre del departamento
     * @return nombre del departamento
     */
    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    /**
     * setter de nombre del departamento
     * @param nombreDepartamento nombre del departamento
     */
    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }
    /**
     * este metodo para agregar nuevo departamento en sistema
     * @throws SQLException 
     */
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
