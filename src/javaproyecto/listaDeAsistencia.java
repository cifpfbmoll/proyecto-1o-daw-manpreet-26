/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luban
 */
public class listaDeAsistencia {
    String a[][];
    int i,j=0;
    public void listaDeAsistencia() {
        try {
            System.out.println("lista de asistencia");
            
            String q = "select * from asistencia";
            PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(q);
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                a[i][j++] = rs.getString("id");
                a[i][j++] = rs.getString("fecha");
                a[i][j++] = rs.getString("asistir");
                i++;
                j=0;
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        }
        }
   
}
