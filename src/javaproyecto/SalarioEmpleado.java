/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

/**
 *
 * @author luban
 */
public class SalarioEmpleado extends registrar {

    private float salarioBasico;
    private float irpf;
    private float baseDeCotitzacio;
    private float salarioNet;

    public SalarioEmpleado() {
    }

    public SalarioEmpleado(float salarioBasico, float irpf, float baseDeCotitzacio, float salarioNet) {
        this.salarioBasico = salarioBasico;
        this.irpf = irpf;
        this.baseDeCotitzacio = baseDeCotitzacio;
        this.salarioNet = salarioNet;
    }
    
    public SalarioEmpleado(int id, String nombre, String apellido1, String apellido2, String nif, String fecha_nacimiento) {
        super(id, nombre, apellido1, apellido2, nif, fecha_nacimiento);
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
    
    public void agragarNuevoEmpleado(){
        System.out.println("El salario base del empleado es : ");
        this.setSalarioBasico(lector.nextFloat());
        System.out.println("La irpf es : ");
        this.setIrpf(lector.nextFloat());
        System.out.println("La base de cotitzación es : ");
        this.setBaseDeCotitzacio(lector.nextFloat());
    }
    
    public void calculaSalario(){
        
        salarioNet = (salarioBasico + baseDeCotitzacio - irpf);
        System.out.println("El salario net es : " + salarioNet);
    }
}
