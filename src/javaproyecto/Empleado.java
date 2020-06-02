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
    /**
     * atributos
     */
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String correo;
    private int movil;
    private float salarioNet;
    private int depId;

    /**
     * Scanenr 
     */
    Scanner lector = new Scanner(System.in);
    
    /**
     * constructor sin parametros
     */
    public Empleado() {
    }

    /**
     * constructor con parametros
     * @param id id del empleado
     * @param nombre nombre del empleado
     * @param apellido1 priimer apellido del empleado
     * @param apellido2 segundo apellido del empleado
     * @param correo correo del empleado
     * @param movil movil del empleado
     * @param salarioNet salarioNet del empleado
     * @param depId  id del departamento del empleado
     */
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

    /**
     * getter de id del empleado
     * @return id del empleado
     */
    public int getEmpId() {
        return id;
    }

    /**
     * setter de id del empleado
     * @param id  id del empleado
     */
    public void setEmpId(int id) {
        this.id = id;
    }

    /**
     * getter de nombre del empleado
     * @return nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * setter de nombre del empleado
     * @param nombre  nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * getter de primer apellido del empleado
     * @return primer apellido del empleado
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * setter de primer apellido del empleado
     * @param apellido1 primer apellido del empleado
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * getter de segundo apellido del empleado
     * @return segundo apellido del empleado
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * setter de segundo apellido del empleado
     * @param apellido2  segundo apellido del empleado
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * getter de correo del empleado
     * @return correo del empleado
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * setter de correo del empleado
     * @param correo  correo del empleado
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * getter de movil
     * @return movil de empleado
     */
    public int getMovil() {
        return movil;
    }

    /**
     * setter de movil 
     * @param movil movil del empleado
     */
    public void setMovil(int movil) {
        this.movil = movil;
    }

    /**
     * getter de salario Neto
     * @return salario Neto del empelado
     */
    public float getSalarioNet() {
        return salarioNet;
    }

    /**
     * setter de salario neto del empleado
     * @param salarioNet salario neto del empleado
     */
    public void setSalarioNet(float salarioNet) {
        this.salarioNet = salarioNet;
    }

    /**
     * getter de id de departamento
     * @return  id de departamento
     */
    public int getDepId() {
        return depId;
    }

    /**
     * setter de  id de departamento
     * @param depId  id de departamento
     */
    public void setDepId(int depId) {
        this.depId = depId;
    }
    
    /**
     * metodo para agregar los datos de empleado en bbbdd
     * @throws SQLException excepcion de sql
     */
    public void agregarEmpleado() throws SQLException{
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
            pst.setString(3,apellido2);
            pst.setString(4, correo);
            pst.setInt(5, movil);
            pst.setInt(6, depId);
            pst.executeUpdate();
    }
           
    /**
     * metodo para actualizar los datos de empleados 
     * @throws SQLException  excepcion de sql
     */
    public void actualizarEmpleado() throws SQLException{
            mostrarDatosDeEmpleados();
        
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
            this.setEmpId(lector.nextInt());
            
            String q = "update empleado set nombre =?,apellido1=?,apellido2=?,correo=?,movil=?,depId=? where empId =?";
            PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(q);
            
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3,apellido2);
            ps.setString(4, correo);
            ps.setInt(5, movil);
            ps.setInt(6, depId);
            ps.setInt(7, id);
            ps.executeUpdate();
            
    }
    /**
     * metodo para mostrar los datos de empleados en bbdd
     * @throws SQLException excepcion de sql
     */
    public void mostrarDatosDeEmpleados() throws SQLException {

        try {
            String q = "select empId,nombre,apellido1,apellido2,correo,movil,depId from empleado";
            PreparedStatement psmnt = conecion_bbdd.establecerConexion().prepareStatement(q);
            ResultSet rs = psmnt.executeQuery();

            while (rs.next()) {
                System.out.println("empID : " + rs.getInt(1));
                System.out.println("nombre : " + rs.getString(2));
                System.out.println("apellido1 : " + rs.getString(3));
                System.out.println("apellido2 : " + rs.getString(4));
                System.out.println("correo : " + rs.getString(5));
                System.out.println("movil : " + rs.getInt(6));
                System.out.println("depId : " + rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}}
