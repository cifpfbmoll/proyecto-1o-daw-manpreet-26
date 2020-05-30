/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

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

    private int id = 1;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private String fecha_nacimiento;
    private String correo;
    private String provincia;
    private String direccion;
    private String genero;
    private int movil;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido1, String apellido2, String nif, String fecha_nacimiento, String correo, String provincia, String direccion, String genero, int movil) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.fecha_nacimiento = fecha_nacimiento;
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

    public int getId() {
        return id++;
    }

    public void setId(int id) {
        this.id = id++;
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

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void agregarNuevoEmpleado() {
        try {

            System.out.println("El nombre del empleado es : ");
            this.setNombre(lector.next());
            System.out.println("El primer apellido del empleado es : ");
            this.setApellido1(lector.next());
            System.out.println("El segundo apellido del empleado es : ");
            this.setApellido2(lector.next());
            System.out.println("El NIF del empleado es : ");
            this.setNif(lector.next());
            System.out.println("La fecha de nacimiento del empleado es : ");
            this.setFecha_nacimiento(lector.next());

            String query = "insert into empleado (nombre,primer_apellido,segundo_apellido,nif,fecha_de_naciemiento) values (?,?,?,?,?)";
            PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);

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
