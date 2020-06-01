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

    /**
     * atributos
     */
    private boolean asistir;
    private Date fecha;

    /**
     * constructor con parametros
     *
     * @param asistir asistencia
     * @param fecha fecha de asistencia
     */
    public asistencia(boolean asistir, Date fecha) {
        this.asistir = asistir;
        this.fecha = fecha;
    }

    /**
     * constructor sin parametros
     */
    public asistencia() {
    }

    /**
     * getter de asistencia
     *
     * @return asistencia que es tipo de boolean
     */
    public boolean isAsistir() {
        return asistir;
    }

    /**
     * setter de asistencia
     *
     * @param asistir asistencia de empleado
     */
    public void setAsistir(boolean asistir) {
        this.asistir = asistir;
    }

    /**
     * getter de fecha
     *
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * setter de fecha
     *
     * @param fecha fecha
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * metodo para asistir los empleados
     *
     * @throws SQLException esto es para buscar algun error
     */
    public void asistenciaEmp() throws SQLException {
        Empleado emp = new Empleado();
        String q = "insert into asistencia (asistir) values(?) where id =?";
        PreparedStatement pst = conecion_bbdd.establecerConexion().prepareStatement(q);
        pst.setBoolean(1, asistir);
        pst.setInt(2, emp.getId());
        ResultSet rst = pst.executeQuery();

        if(rst.next()){
            System.out.println("He insertado");
        }else{
            System.out.println("tiene error");
        }
    }
}
