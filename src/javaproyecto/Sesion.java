/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

/**
 *
 * @author luban
 */
public class Sesion {

    static Scanner lector = new Scanner(System.in);

    /**
     * metodo para iniciar sesion  de los empleados despues de hacer conexion
     * @param miconexion nombre de Connection 
     * @return  sesion es verdadero o falso
     * @throws SQLException excepcion
     */
    public static boolean iniciarSesion(Connection miconexion) throws SQLException {

        boolean ifSesion = false;
        System.out.println("Usuario : ");
        String usuario = lector.next();
        System.out.println("Contraseña : ");
        String contraseña = lector.next();

        if (usuario != null && contraseña != null) {
            String query = "select * from iniciar_sesion where  usuario  =?  and contraseña =?";
            
            PreparedStatement ps = miconexion.prepareStatement(query);

            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Conectado");
                ifSesion = true;

            } else {
                System.out.println("Invalido usuario o contraseña.Introduce otra vez");

                miconexion.close();
            }
        }
        return ifSesion;

    }
    
    
}
