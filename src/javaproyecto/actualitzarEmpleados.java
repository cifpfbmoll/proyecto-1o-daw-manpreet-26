/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luban
 */
public class actualitzarEmpleados {
    /**
     * metodo para actualitzar los datos de los empelados
     * @throws SQLException este excepcion es de tipo de sql
     */
    public void actualizarEmpleado() throws SQLException{
       
        Empleado antiEmp = new Empleado();
        String query = "update empleado set nombre = ?,apellido1 = ?,apellido2 = ?,genero = ?,movil = ?,correo = ?,provincia = ?,nif = ?,fechaDeNacimiento = ?,direccion = ? where id = ?";
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(query);
        
        
        pst.setString(1, antiEmp.getNombre());
        pst.setString(2, antiEmp.getApellido1());
        pst.setString(3,antiEmp.getApellido2());
        pst.setString(4, antiEmp.getGenero());
        pst.setInt(5, antiEmp.getMovil());
        pst.setString(6, antiEmp.getCorreo());
        pst.setString(7, antiEmp.getProvincia());
        pst.setString(8, antiEmp.getNif());
        pst.setString(9,antiEmp.getFechaDeNacimiento());
        pst.setString(10, antiEmp.getDireccion());
        
       pst.executeUpdate();
        
        
    }
}
