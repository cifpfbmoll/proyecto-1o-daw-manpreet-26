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
 *
 * @author luban
 */
public class SalarioEmpleado extends Empleado {

    private float salarioBasico;
    private float irpf;
    private float baseDeCotitzacio;
    private float salarioNet;

    public SalarioEmpleado(String nombre, String apellido1, String apellido2, String nif, String fecha_nacimiento, String correo, String provincia, String direccion, String genero, int movil) {
        super(nombre, apellido1, apellido2, nif, fecha_nacimiento, correo, provincia, direccion, genero, movil);
    }

    public SalarioEmpleado() {
    }

    public SalarioEmpleado(float salarioBasico, float irpf, float baseDeCotitzacio, float salarioNet) {
        this.salarioBasico = salarioBasico;
        this.irpf = irpf;
        this.baseDeCotitzacio = baseDeCotitzacio;
        this.salarioNet = salarioNet;
    }

    public float getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(float salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public float getIrpf() {
        return irpf;
    }

    public void setIrpf(float irpf) {
        this.irpf = irpf;
    }

    public float getBaseDeCotitzacio() {
        return baseDeCotitzacio;
    }

    public void setBaseDeCotitzacio(float baseDeCotitzacio) {
        this.baseDeCotitzacio = baseDeCotitzacio;
    }

    public float getSalarioNet() {
        return salarioNet;
    }

    public void setSalarioNet(float salarioNet) {
        this.salarioNet = salarioNet;
    }

    public void agragarNuevoEmpleado() {
        System.out.println("El salario base del empleado es : ");
        this.setSalarioBasico(lector.nextFloat());
        System.out.println("La irpf es : ");
        this.setIrpf(lector.nextFloat());
        System.out.println("La base de cotitzación es : ");
        this.setBaseDeCotitzacio(lector.nextFloat());
    }

    public void calculaSalario() {

        salarioNet = (salarioBasico + baseDeCotitzacio - irpf);
        System.out.println("El salario net es : " + salarioNet);
    }
    
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
