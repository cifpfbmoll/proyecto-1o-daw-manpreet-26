/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luban
 */
public class conecion_bbdd {

    private final static String user = "root";
    private final static String password = "";
    private final static String database = "jdbc:mysql://localhost:3306/proyecto_java";
    public Connection c;
    public Statement s;

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getDatabase() {
        return database;
    }

    public static void conn() throws SQLException, IOException {
        try {
            Connection con = DriverManager.getConnection(getDatabase(), getUser(), getPassword());
            Statement st = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///proyecto_java", "root", "");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
