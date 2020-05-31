/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author luban
 */
public class Empleado {

    Scanner lector = new Scanner(System.in);

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private Date fechaDeNacimiento;
    private String correo;
    private String provincia;
    private String direccion;
    private String genero;
    private int movil;

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido1, String apellido2, String nif, Date fechaDeNacimiento, String correo, String provincia, String direccion, String genero, int movil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correo = correo;
        this.provincia = provincia;
        this.direccion = direccion;
        this.genero = genero;
        this.movil = movil;
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public void agregarNuevoEmpleado() {
        try {
            this.id = id++;  //autoincrement
            System.out.println("El nombre del empleado es : ");
            this.setNombre(lector.next());
            System.out.println("El primer apellido del empleado es : ");
            this.setApellido1(lector.next());
            System.out.println("El segundo apellido del empleado es : ");
            this.setApellido2(lector.next());
            System.out.println("El NIF del empleado es : ");
            this.setNif(lector.next());
            System.out.println("La fecha de nacimiento del empleado es : ");
            this.setFechaDeNacimiento(lector.next());

            String query = "insert into empleado (nombre,apellido1,apellido2,nif,fechaDeNaciemiento,genero,movil,provincia,correo,direccion) values (?,?,?,?,?,?,?,?,?,?) where id =?";
            PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);

            pst.setString(1, nombre);
            pst.setString(2, apellido1);
            pst.setString(3, apellido2);
            pst.setString(4, nif);
            pst.setDate(5, fechaDeNacimiento);
            pst.setString(6, genero);
            pst.setInt(7, movil);
            pst.setString(8, provincia);
            pst.setString(9, correo);
            pst.setString(10, direccion);
            ResultSet rst = pst.executeQuery();

            if (rst.next()) {
                System.out.println("He insertado");
            } else {
                System.out.println("error");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
