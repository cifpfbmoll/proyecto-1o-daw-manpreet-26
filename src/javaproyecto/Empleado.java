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
public class Empleado {

    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private int movil;
    private float salarioNet;
    private int depId;

    Scanner lector = new Scanner(System.in);

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido1, String apellido2, String correo, int movil, float salarioNet, int depId) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.movil = movil;
        this.salarioNet = salarioNet;
        this.depId = depId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public float getSalarioNet() {
        return salarioNet;
    }

    public void setSalarioNet(float salarioNet) {
        this.salarioNet = salarioNet;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public void agregarEmpleado() throws SQLException {
        this.id = id++;  //autoincrement
        System.out.println("El nombre del empleado es : ");
        this.setNombre(lector.next());
        System.out.println("El primer apellido del empleado es : ");
        this.setApellido1(lector.next());
        System.out.println("El segundo apellido del empleado es : ");
        this.setApellido2(lector.next());
        System.out.println("El correo del empelado es : ");
        this.setCorreo(lector.next());
        System.out.println("El movil del empleado es : ");
        this.setMovil(lector.nextInt());
        System.out.println("El id de departamento del empleado es : ");
        this.setDepId(lector.nextInt());
        String query = "insert into empleado(empId,nombre,apellido1,apellido2,correo,movil,depId) values (null,?,?,?,?,?,?)";
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);

        pst.setString(1, nombre);
        pst.setString(2, apellido1);
        pst.setString(3, apellido2);
        pst.setString(4, correo);
        pst.setInt(5, movil);
        pst.setInt(6, depId);
        pst.executeUpdate();
    }

    public void actualizarEmpleado() throws SQLException {
        System.out.println("El nombre del empleado es : ");
        this.setNombre(lector.next());
        System.out.println("El primer apellido del empleado es : ");
        this.setApellido1(lector.next());
        System.out.println("El segundo apellido del empleado es : ");
        this.setApellido2(lector.next());
        System.out.println("El correo del empelado es : ");
        this.setCorreo(lector.next());
        System.out.println("El movil del empleado es : ");
        this.setMovil(lector.nextInt());
        System.out.println("El id de departamento del empleado es : ");
        this.setDepId(lector.nextInt());
        System.out.println("introduce el id del empleado ");
        this.setId(lector.nextInt());

        String q = "update empleado set nombre =?,apellido1=?,apellido2=?,correo=?,movil=?,depId=? where empId =?";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(q);

        ps.setString(1, nombre);
        ps.setString(2, apellido1);
        ps.setString(3, apellido2);
        ps.setString(4, correo);
        ps.setInt(5, movil);
        ps.setInt(6, depId);
        ps.setInt(7, id);
        ps.executeUpdate();

    }

}
