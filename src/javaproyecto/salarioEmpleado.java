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

    /**
     * atributos
     */
    private int empId;
    private float salarioBase;
    private float irpf;
    private float baseDeCotitzacion;
    private float salarioNet;

    Scanner input = new Scanner(System.in);

    /**
     * constructor sin parametros
     */
    public salarioEmpleado() {
    }

    /**
     * constructor con parametros
     * @param id id del empleado
     * @param salarioBase salarioBase del empleado
     * @param irpf irpf del empleado
     * @param baseDeCotitzacion  base de cotitzacion del empleado
     * @param salarioNet salario neto del empleado
     */
    public salarioEmpleado(int id, float salarioBase, float irpf, float baseDeCotitzacion, float salarioNet) {
        this.empId = id;
        this.salarioBase = salarioBase;
        this.irpf = irpf;
        this.baseDeCotitzacion = baseDeCotitzacion;
        this.salarioNet = salarioNet;
    }


    /**
     * constructor de clase padre empleado
     @param id id del empleado
     * @param nombre nombre del empleado
     * @param apellido1 priimer apellido del empleado
     * @param apellido2 segundo apellido del empleado
     * @param correo correo del empleado
     * @param movil movil del empleado
     * @param salarioNet salarioNet del empleado
     * @param depId  id del departamento del empleado
     */
    public salarioEmpleado(int id, String nombre, String apellido1, String apellido2, String correo, int movil, float salarioNet, int depId) {
        super(id, nombre, apellido1, apellido2, correo, movil, salarioNet, depId);
    }

    /**
     * getter de salario Base del empelado
     * @return salarioBase del empelado
     */
    public float getSalarioBase() {
        return salarioBase;
    }

    /**
     * setter de salario Base del empelado
     * @param salarioBase  salario Base del empelado
     */
    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    /**
     * getter de irpf del empleado
     * @return irpf del empleado
     */
    public float getIrpf() {
        return irpf;
    }

    /**
     * setter de irpf del empleado
     * @param irpf irpf del empleado
     */
    public void setIrpf(float irpf) {
        this.irpf = irpf;
    }

    /**
     * getter de BaseDeCotitzacion 
     * @return BaseDeCotitzacion del empleado
     */
    public float getBaseDeCotitzacion() {
        return baseDeCotitzacion;
    }

    /**
     * setter de BaseDeCotitzacion
     * @param baseDeCotitzacion BaseDeCotitzacion del empleado
     */
    public void setBaseDeCotitzacion(float baseDeCotitzacion) {
        this.baseDeCotitzacion = baseDeCotitzacion;
    }

    /**
     * getter override 
     * @return salrio neto
     */
    public float getSalarioNet() {
        return salarioNet;
    }

    /**
     * setter override
     * @param salarioNet salrio neto
     */
    public void setSalarioNet(float salarioNet) {
        this.salarioNet = salarioNet;
    }

    /**
     * getter de id del empleado
     * @return id del empleado
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * setter de id del empleado
     * @param empId in del empelado
     */
    public void setEmpId(int empId) {
        this.empId = empId;
    }

    /**
     * este metodo para calcular salario Neto
     */
    public void calculaSalarioNeto() {
        salarioNet = ((salarioBase + baseDeCotitzacion) - irpf);
        System.out.println("El salario neto es : " + salarioNet);
    }

    /**
     * este metodo para agregar salario del empleado
     * @throws SQLException excepcion de sql
     */
    @Override
    public void agregarEmpleado() throws SQLException {
        this.empId++;
        System.out.println("El salario base del empleado es : ");
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

    /**
     * este metodo para actualizar el salario del empleado
     * @throws SQLException 
     */
    @Override
    public void actualizarEmpleado() throws SQLException {
        System.out.println("El salario base del empleado es : ");
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

    /**
     * este metodo para mostrar salario del empleado
     * @throws SQLException 
     */
    
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
   
}
