/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.util.Scanner;

/**
 *
 * @author luban
 */
public class registrar {
        Scanner lector = new Scanner(System.in);
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String nif;
    private String fecha_nacimiento;

    public registrar() {
    }

    public registrar(String nombre, String apellido1, String apellido2, String nif, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nif = nif;
        this.fecha_nacimiento = fecha_nacimiento;
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
    
    public void agregarNuevoEmpleado(){
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
    }
}
