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
public class salarioEmpleado extends Empleado {

    private int empId;
    private float salarioBase;
    private float irpf;
    private float baseDeCotitzacion;
    private float salarioNet;

    Scanner input = new Scanner(System.in);

    public salarioEmpleado() {
    }

    public salarioEmpleado(int id, float salarioBase, float irpf, float baseDeCotitzacion, float salarioNet) {
        this.empId = id;
        this.salarioBase = salarioBase;
        this.irpf = irpf;
        this.baseDeCotitzacion = baseDeCotitzacion;
        this.salarioNet = salarioNet;
    }


    public salarioEmpleado(int id, String nombre, String apellido1, String apellido2, String correo, int movil, float salarioNet, int depId) {
        super(id, nombre, apellido1, apellido2, correo, movil, salarioNet, depId);
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getIrpf() {
        return irpf;
    }

    public void setIrpf(float irpf) {
        this.irpf = irpf;
    }

    public float getBaseDeCotitzacion() {
        return baseDeCotitzacion;
    }

    public void setBaseDeCotitzacion(float baseDeCotitzacion) {
        this.baseDeCotitzacion = baseDeCotitzacion;
    }

    public float getSalarioNet() {
        return salarioNet;
    }

    public void setSalarioNet(float salarioNet) {
        this.salarioNet = salarioNet;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    
    public void calculaSalarioNeto() {
        salarioNet = ((salarioBase + baseDeCotitzacion) - irpf);
        System.out.println("El salario net es : " + salarioNet);
    }

    public void agregarEmpleado() throws SQLException {
        this.empId++;
        System.out.println("El salario basico del empleado es : ");
        this.setSalarioBase(input.nextFloat());
        System.out.println("El IRPF del empleado es :");
        this.setIrpf(input.nextFloat());
        System.out.println("La base de cotitzación del empleado es :");
        this.setBaseDeCotitzacion(input.nextFloat());
        this.calculaSalarioNeto();

        String query = "insert into salario(empId,salarioBase,irpf,baseDeCotitzacion,salarioNeto) values (?,?,?,?,?)";

        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);

        pst.setInt(1, empId);
        pst.setFloat(2, salarioBase);
        pst.setFloat(3, irpf);
        pst.setFloat(4, baseDeCotitzacion);
        pst.setFloat(5, salarioNet);

        pst.executeUpdate();
    }

    public void actualizarEmpleado() throws SQLException {
        System.out.println("El salario basico del empleado es : ");
        this.setSalarioBase(input.nextFloat());
        System.out.println("El IRPF del empleado es :");
        this.setIrpf(input.nextFloat());
        System.out.println("La base de cotitzación del empleado es :");
        this.setBaseDeCotitzacion(input.nextFloat());
        this.calculaSalarioNeto();
        System.out.println("El id del empleado es : ");
        this.setEmpId(input.nextInt());

        String q = "update salario set salarioBase=?,irpf=?,baseDeCotitzacion=?,salarioNeto=? where empId=?";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(q);

        ps.setFloat(1, salarioBase);
        ps.setFloat(2, irpf);
        ps.setFloat(3, baseDeCotitzacion);
        ps.setFloat(4, salarioNet);
        ps.setInt(5, empId);
        ps.executeUpdate();

    }

    public void mostrarDatosDeEmpleados() throws SQLException {
        
        System.out.println("El id del empleado es : ");
        this.setEmpId(input.nextInt());

        String qu = "select empId,salarioBase,irpf,baseDeCotitzacion,salarioNeto from salario";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(qu);
        ps.setInt(1, this.getEmpId());
        ResultSet rs = ps.executeQuery();
        System.out.println("ID del empleado : " + rs.getInt(1));
        System.out.println("Salario base :" + rs.getFloat(2));
        System.out.println("irpf :" + rs.getFloat(3));
        System.out.println("base de cotitzacion :" + rs.getFloat(4));
        System.out.println("salario neto :" + rs.getFloat(5));

    }

    public void mostrarSalario() throws SQLException {

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
    /*public void mostrarDatosDeEmpleados() throws SQLException {

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
        }*/
}
