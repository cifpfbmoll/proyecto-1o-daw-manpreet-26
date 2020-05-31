/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * clase para agregar dato de salario del empleado
 * @author luban
 */
public class SalarioEmpleado extends Empleado {

    /**
     * atriibutos
     */
    private float salarioBasico;
    private float irpf;
    private float baseDeCotitzacio;
    private float salarioNet;

    /**
     * constructor sin parametros
     */
    public SalarioEmpleado() {
    }

    /**
     * constructor con parametros
     * @param salarioBasico salario basico del empleado
     * @param irpf irpf del empleado
     * @param baseDeCotitzacio base de cotitzacio del empleado
     * @param salarioNet salario net del empleado
     */
    public SalarioEmpleado(float salarioBasico, float irpf, float baseDeCotitzacio, float salarioNet) {
        this.salarioBasico = salarioBasico;
        this.irpf = irpf;
        this.baseDeCotitzacio = baseDeCotitzacio;
        this.salarioNet = salarioNet;
    }

    /**
     * getter de salario basico
     * @return salario basico del empleado
     */
    public float getSalarioBasico() {
        return salarioBasico;
    }

    /**
     * setter de salario basico
     * @param salarioBasico salariobasico del empleado
     */
    public void setSalarioBasico(float salarioBasico) {
        this.salarioBasico = salarioBasico;
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
     * @param irpf  irpf del empleado
     */
    public void setIrpf(float irpf) {
        this.irpf = irpf;
    }

    /**
     * getter de base de cotitzacio del empleado
     * @return 
     */
    public float getBaseDeCotitzacio() {
        return baseDeCotitzacio;
    }

    /**
     * setter de base de cotitzacio
     * @param baseDeCotitzacio base de cotitzacio del empelado
     */
    public void setBaseDeCotitzacio(float baseDeCotitzacio) {
        this.baseDeCotitzacio = baseDeCotitzacio;
    }

    /**
     * getter de salario net
     * @return salario net del empleado
     */
    public float getSalarioNet() {
        return salarioNet;
    }

    /**
     * setter de salario net
     * @param salarioNet salario net del empleado
     */
    public void setSalarioNet(float salarioNet) {
        this.salarioNet = salarioNet;
    }

    /**
     * metdoo para agregar salario del empleado
     */
    public void agragarNuevoEmpleado() {
        System.out.println("El salario base del empleado es : ");
        this.setSalarioBasico(lector.nextFloat());
        System.out.println("La irpf es : ");
        this.setIrpf(lector.nextFloat());
        System.out.println("La base de cotitzación es : ");
        this.setBaseDeCotitzacio(lector.nextFloat());
    }

    /**
     * metodo para calcular salrio net
     */
    public void calculaSalario() {

        salarioNet = (salarioBasico + baseDeCotitzacio - irpf);
        System.out.println("El salario net es : " + salarioNet);
    }
    /**
     * metodo para insertar salario del empleado en base de datos
     * @throws SQLException 
     */
    public void salarioSql() throws SQLException{
        String query = "insert into salario (salario_base,irpf,base_de_cotitzacion,salario_net) values (?,?,?,?)";
        
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);
        
        ps.setFloat(1, salarioBasico);
        ps.setFloat(2, irpf );
        ps.setFloat(3, baseDeCotitzacio );
        ps.setFloat(4, salarioNet);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            System.out.println("He insertado");
        }else{
            System.out.println("tiene error");
        }
    }
}
