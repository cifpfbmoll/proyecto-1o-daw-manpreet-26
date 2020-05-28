/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luban
 */
public class conecion_bbdd {

    //here i have attributes of connection and statement as well user ,password and database that i have in my database
    private final static String user = "root";
    private final static String password = "";
    private final static String database = "jdbc:mysql://localhost:3306/proyecto_java";

    public Connection c;

    //getter of attributes
    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDatabase() {
        return database;
    }

    public static Connection establecerConexion() throws SQLException {
        Connection con = DriverManager.getConnection(getDatabase(), getUser(), getPassword());
        return con;
    }

    

    
}
