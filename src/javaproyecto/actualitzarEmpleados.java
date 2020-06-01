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
public class actualitzarEmpleados extends Empleado {

    /**
     * metodo para actualitzar los datos de los empelados
     *
     * @throws SQLException este excepcion es de tipo de sql
     */
    public void actualizarEmpleado() throws SQLException {

        Empleado antiEmp = new Empleado();

        System.out.println("El nombre del empleado es : ");
        this.setNombre(lector.next());
        System.out.println("El primer apellido del empleado es : ");
        this.setApellido1(lector.next());
        System.out.println("El segundo apellido del empleado es : ");
        this.setApellido2(lector.next());
        System.out.println("El NIF del empleado es : ");
        this.setNif(lector.next());
        System.out.println("La fecha de nacimiento del empleado es : ");
        this.setFechaDeNacimiento(lector.next());
        System.out.println("El genero del empleado es : ");
        this.setGenero(lector.next());
        System.out.println("El movil del empleado es : ");
        this.setMovil(lector.nextInt());
        System.out.println("El provincia del empleado es : ");
        this.setProvincia(lector.next());
        System.out.println("El correo del empelado es : ");
        this.setCorreo(lector.next());
        System.out.println("La direccion del empleado es : ");
        this.setDireccion(lector.next());
        System.out.println("El salario basico del empleado es : ");
        this.setSalarioBasico(lector.nextFloat());
        System.out.println("El IRPF del empleado es :");
        this.setIrpf(lector.nextFloat());
        System.out.println("La base de cotitzación del empleado es :");
        this.setBaseDeCotitzacion(lector.nextFloat());
        System.out.println("El salario net del empleado es :");
        this.calculaSalario();
        String query = "update empleadoSalario set nombre = ?,apellido1 = ?,apellido2 = ?,genero = ?,movil = ?,correo = ?,"
                + "provincia = ?,nif = ?,fechaDeNacimiento = ?,direccion = ?,salarioBasico = ?,irpf = ?,baseDeCotitzacio = ?, where id = ?" ;
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);
        ResultSet rst = null;
        pst.setString(1, antiEmp.getNombre());
        pst.setString(2, antiEmp.getApellido1());
        pst.setString(3, antiEmp.getApellido2());
        pst.setString(4, antiEmp.getGenero());
        pst.setInt(5, antiEmp.getMovil());
        pst.setString(6, antiEmp.getCorreo());
        pst.setString(7, antiEmp.getProvincia());
        pst.setString(8, antiEmp.getNif());
        pst.setString(9, antiEmp.getFechaDeNacimiento());
        pst.setString(10, antiEmp.getDireccion());
        pst.setFloat(11, antiEmp.getSalarioBasico());
        pst.setFloat(12, antiEmp.getIrpf());
        pst.setFloat(13, antiEmp.getBaseDeCotitzacion());
        pst.setInt(14, antiEmp.getId());
        pst.executeUpdate();

    }
}
