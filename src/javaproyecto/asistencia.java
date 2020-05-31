/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

/**
 *
 * @author luban
 */
public class asistencia {

    private boolean asistir;
    private Date fecha;

    public asistencia(boolean asistir, Date fecha) {
        this.asistir = asistir;
        this.fecha = fecha;
    }

    
    public asistencia() {
    }

    public boolean isAsistir() {
        return asistir;
    }

    public void setAsistir(boolean asistir) {
        this.asistir = asistir;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void asistenciaEmp() throws SQLException {
        Empleado emp = new Empleado();
        String q = "insert into asistencia (asistir) values(?) where id =?";
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(q);
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            pst.setBoolean(1, asistir);
            pst.setInt(2, emp.getId());
        }
    }
}
