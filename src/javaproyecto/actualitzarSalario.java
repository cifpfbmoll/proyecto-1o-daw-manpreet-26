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
public class actualitzarSalario {

    SalarioEmpleado salarioDeEmpleado = new SalarioEmpleado();

    public void actulitzaSalarioDeEmpleado() throws SQLException {
        String query = "update salario set salarioBascio = ?,irpf = ?,baseDeCotitzacio = ? where id = ?";
        PreparedStatement ps = conecion_bbdd.establecerConexion().prepareStatement(query);
        
        ps.setFloat(1,salarioDeEmpleado.getSalarioBasico() );
        ps.setFloat(2, salarioDeEmpleado.getIrpf());
        ps.setFloat(3, salarioDeEmpleado.getBaseDeCotitzacio());
        
        ResultSet rs = ps.executeQuery();
        

    }
}
