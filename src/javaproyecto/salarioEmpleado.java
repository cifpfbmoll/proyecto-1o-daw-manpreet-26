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

    private float salarioBase;
    private float irpf;
    private float baseDeCotitzacion;
    private float salarioNet;

    Scanner input = new Scanner(System.in);

    public salarioEmpleado() {
    }

    public salarioEmpleado(float salarioBase, float irpf, float baseDeCotitzacion, float salarioNet) {
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

    public void calculaSalarioNeto() {
        salarioNet = ((salarioBase + baseDeCotitzacion) - irpf);
        System.out.println("El salario net es : " + salarioNet);
    }

    public void agregarEmpleado() throws SQLException {
        System.out.println("El salario basico del empleado es : ");
        this.setSalarioBase(input.nextFloat());
        System.out.println("El IRPF del empleado es :");
        this.setIrpf(input.nextFloat());
        System.out.println("La base de cotitzación del empleado es :");
        this.setBaseDeCotitzacion(input.nextFloat());
        this.calculaSalarioNeto();

        String query = "insert into salario(empId,salarioBase,irpf,baseDeCotitzacion,salarioNeto) values (null,?,?,?,?)";

        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);

        pst.setFloat(1, salarioBase);
        pst.setFloat(2, irpf);
        pst.setFloat(3, baseDeCotitzacion);
        pst.setFloat(4, salarioNet);

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
        this.setId(input.nextInt());
        
        String q = "update salario set salarioBase=?,irpf=?,baseDeCotitzacion=?,salarioNeto=? where empId=?";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(q);
        
        ps.setFloat(1, salarioBase);
        ps.setFloat(2, irpf);
        ps.setFloat(3, baseDeCotitzacion);
        ps.setFloat(4, salarioNet);
        ps.setInt(5, this.getId());
        ps.executeUpdate();
        
    }
    
    public void generarNomina() throws SQLException{
        System.out.println("El id del empleado es : ");
        this.setId(input.nextInt());
        
        String qu = "select * from salario where empId =?";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(qu);
        ps.setInt(1, this.getId());
        ResultSet rs = ps.executeQuery();
        System.out.println("Salario base :" + rs.getFloat((int) salarioBase));
        System.out.println("irpf :" + this.getIrpf());
        System.out.println("base de cotitzacion :" + this.getBaseDeCotitzacion());
        System.out.println("salario neto :" + this.getSalarioNet());
        
    }

}
