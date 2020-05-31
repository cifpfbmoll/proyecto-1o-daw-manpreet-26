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

    /**
     * Atributos 
     */
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

    /**
     * constructor sin parametros
     */
    public Empleado() {
    }

    /**
     * constructor con parametros
     * @param id id del empleado
     * @param nombre nombre del empleado
     * @param apellido1 primer apellido del empleado
     * @param apellido2 segundo apellido del empleado
     * @param nif nif del empleado
     * @param fechaDeNacimiento  fecha de nacimiento del empleado
     * @param correo correo del empleado
     * @param provincia provincia del empleado
     * @param direccion direccion del empleado
     * @param genero genero del empleado
     * @param movil movil del empleado
     */
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

    /**
     * 
     * @return corrreo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Getter para provincia
     * @return provinica del empleado
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * setter para provincia
     * @param provincia 
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * getter para direccion
     * @return direccion del empleado
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return genero del empleado
     */
    public String getGenero() {
        return genero;
    }

    /**
     * 
     * @param genero 
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * 
     * @return movil del empleado
     */
    public int getMovil() {
        return movil;
    }

    /**
     * 
     * @param movil 
     */
    public void setMovil(int movil) {
        this.movil = movil;
    }

    /**
     * 
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return primer apellido del empleado
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * 
     * @param apellido1 
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return segundo apellido del empleado
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * 
     * @param apellido2 segundo apellido del empleado
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * 
     * @return nif del empleado
     */
    public String getNif() {
        return nif;
    }

    /**
     * 
     * @param nif nif del empleado
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * 
     * @return fecha de nacimiento del empleado
     */
    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * 
     * @param fechaDeNacimiento fecha de nacimiento del empleado
     */
    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * 
     * @return id del empleado
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id id del empleado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * metodo para insertar nuevo empleado en base de dato
     * usado insert query para insertar
     * hemos usado prepared statement
     * 
     */
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
            //this.setFechaDeNacimiento(lector.nextLine());

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
